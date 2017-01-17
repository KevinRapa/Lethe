package Escape_Tunnel;

import static A_Main.NameConstants.METAL_BAR;
import A_Main.Player;
import A_Super.Furniture;
import A_Super.Item;
import A_Super.Resetable;
/**
 * Player must pry this with the metal bar before climbing up the ladder into
 * SEWP.
 * 
 * @author Kevin Rapa
 */
public class Esc6_Grt extends Furniture implements Resetable {
    private final String MOVED_GRATE = "You've already moved the grate!";
    private boolean opened;
    // ========================================================================
    public Esc6_Grt (Item... items) {
        super(items);
        this.searchable = false;
        
        this.description = "The metal grate blocks access to the above room.";
        this.actDialog = "It's too heavy. You can't open it.";
        this.useDialog = "You jam the bar in the corner of the grate. The grate pops\n"
                       + "up a bit, and you force the bar in more. With the rest of\n"
                       + "your strength, you pop the grate out.";

        this.addNameKeys("(?:metal )?grate");
        this.addUseKeys(METAL_BAR);
        this.addActKeys("lift", "move", "pry");
    }
    // ======================================================================== 
    @Override public String getDescription() {
        return this.opened ? "The grate has been moved." : this.description;
    }
    // ========================================================================   
    @Override public String getSearchDialog() {
        return this.opened ? "The ladder goes down a ways. You estimate about 30 feet." : 
                this.searchDialog;
    }
    // ========================================================================   
    @Override public String interact(String key) {  
        if (key.equals("lift") || key.equals("move")) 
            return opened ? MOVED_GRATE : this.actDialog;
        else if (Player.hasItem(METAL_BAR)) {
            return this.useEvent(null); // Safe. Arg unused here.
        }
        else
            return "You have nothing to do that with.";
    }
    // ========================================================================     
    @Override public String useEvent(Item item) {
        if (! opened) {
            this.opened = true;
            return this.useDialog;
        }
        else
            return MOVED_GRATE;
    }
    // ======================================================================== 
    @Override public void reset() {
        this.opened = false;
    }
    // ======================================================================== 
    public boolean isMoved() {
        return this.opened;
    }
    // ======================================================================== 
}


