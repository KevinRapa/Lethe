package Cell;

import A_Main.Id;
import A_Main.Player;
import A_Super.Furniture;
import A_Super.Item;
import A_Super.Resetable;
/**
 * The player must move this grate with a metal bar found in the noisy room
 * in order to escape.
 * 
 * @author Kevin Rapa
 */
public class Intr_Grt extends Furniture implements Resetable {
    private boolean opened;
    private final String MOVED_GRATE = "You've already moved the grate!";
    // ========================================================================
    public Intr_Grt (Item... items) {
        super(items);
        this.searchable = false;
        
        this.description = "The water in the room drains through this grate here.\n"
                         + "Squinting though it, you spot what you believe to be\n"
                         + "the top rung of a ladder.";
        this.actDialog = "It's too heavy. You can't open it.";
        this.useDialog = "With a lot of strength, you manage to move the grating out of the way.";
        this.searchDialog = "There's nothing unusual... Though squinting through the grate,\n"
                          + "you see what looks like the top rung of a ladder.";

        this.addNameKeys("(?:metal )?(?:grate|ladder)");
        this.addActKeys("jump", "climb", "lift", "move", "descend", "pry");
        this.addUseKeys("metal bar");
    }
    // ======================================================================== 
    @Override public String getDescription() {
        return this.opened ? "The open hole in the floor reveals a simple\n"
                           + "ladder leading downwards." : this.description;
    }
    // ========================================================================   
    @Override public String getSearchDialog() {
        return this.opened ? "The ladder goes down a ways, you estimate about 30 feet." : 
                this.searchDialog;
    }
    // ========================================================================   
    @Override public String interact(String key) {  
        if (key.equals("lift") || key.equals("move")) 
            return opened ? MOVED_GRATE : this.actDialog;
        else if (key.equals("pry") && Player.hasItem("metal bar")) {
            return this.useEvent(null); // Safe. Arg unused here.
        }
        else
            return opened ? transport() : "You aren't going anywhere with that grate closed.";
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
    private String transport() {
        Player.setOccupies(Id.ESC1);
        return "You climb down the ladder a ways into a small noisy tunnel.";
    }
    // ======================================================================== 
}


