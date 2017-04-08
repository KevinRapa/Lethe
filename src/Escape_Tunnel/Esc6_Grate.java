package Escape_Tunnel;

import A_Main.AudioPlayer;
import static A_Main.Names.METAL_BAR;
import A_Main.Player;
import A_Super.Furniture;
import A_Super.Gettable;
import A_Super.Item;
import A_Super.Resetable;
/**
 * Player must pry this with the metal bar before climbing up the ladder into
 * SEWP.
 * 
 * @author Kevin Rapa
 */
public class Esc6_Grate extends Furniture implements Resetable, Gettable {
    private final String MOVED_GRATE = "You've already moved the grate!";
    private boolean opened;
    // ========================================================================
    public Esc6_Grate () {
        super();

        this.description = "The metal grate blocks access to the above room.";
        this.actDialog = "It's too heavy. You can't open it.";
        this.useDialog = "You jam the bar in the corner of the grate. The grate pops "
                       + "up a bit, and you force the bar in more. With the rest of "
                       + "your strength, you pop the grate out.";

        this.addNameKeys("(?:metal )?grate");
        this.addUseKeys(METAL_BAR);
        this.addActKeys("lift", "move", "pry");
        this.addActKeys(GETPATTERN);
    }
    // ======================================================================== 
    @Override public String getDescription() {
        return opened ? "The grate has been moved." : description;
    }
    // ========================================================================   
    @Override public String getSearchDialog() {
        return opened ? "The ladder goes up about 30 feet." : searchDialog;
    }
    // ========================================================================   
    @Override public String interact(String key) {  
        if (key.equals("lift") || key.equals("move")) 
            return opened ? MOVED_GRATE : this.actDialog;
        else if (key.equals("pry") && Player.hasItem(METAL_BAR))
            return this.useEvent(null); // Safe. Arg unused here.
        else if (key.equals("pry"))
            return "You have nothing to do that with.";
        else
            return getIt();
    }
    // ========================================================================     
    @Override public String useEvent(Item item) {
        if (! opened) {
            AudioPlayer.playEffect(48);
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


