package Cell;

import A_Main.AudioPlayer;
import A_Main.Id;
import static A_Main.Names.METAL_BAR;
import A_Main.Patterns;
import A_Main.Player;
import A_Super.Climbable;
import A_Super.Direction;
import A_Super.Furniture;
import A_Super.Gettable;
import A_Super.Item;
import A_Super.Resetable;
/**
 * The player must move this grate with a metal bar found in the noisy room
 * in order to escape.
 * 
 * @author Kevin Rapa
 */
public class Intr_Grate extends Furniture 
        implements Resetable, Gettable, Climbable 
{
    private boolean opened;
    private final String MOVED_GRATE = "You've already moved the grate!";
    //-------------------------------------------------------------------------
    public Intr_Grate () {
        super();
        
        this.description = "The water in the room drains through this grate here. "
                         + "Squinting though it, you spot what you believe to be "
                         + "the top rung of a ladder.";
        this.actDialog = "It's too heavy. You can't open it.";
        this.useDialog = "With a lot of strength, you manage to move the grating out of the way.";
        this.searchDialog = "There's nothing unusual... Though squinting through the grate, "
                          + "you see what looks like the top rung of a ladder.";

        this.addNameKeys("(?:metal )?(?:grate|ladder|drain)", "hole");
        this.addActKeys("jump", CLIMBPATTERN, MOVEPATTERN, "pry", "open", "lift");
        this.addActKeys(GETPATTERN);
        this.addUseKeys(METAL_BAR);
    }
    //------------------------------------------------------------------------- 
    @Override public String getDescription() {
        return this.opened ?
                "The open hole in the floor reveals a simple ladder leading downwards." : this.description;
    }
    //-------------------------------------------------------------------------   
    @Override public String getSearchDialog() {
        return this.opened ? "The ladder goes down a ways; you estimate about 30 feet." : 
                this.searchDialog;
    }
    //-------------------------------------------------------------------------   
    @Override public String interact(String key) {  
        if (key.matches(MOVEPATTERN) || key.equals("open") || key.equals("lift")) 
            return opened ? 
                    MOVED_GRATE : this.actDialog;
        
        else if (key.equals("pry"))
            return Player.hasItem(METAL_BAR) ? 
                    this.useEvent(null) : "You have nothing good to pry with.";
        
        else if (key.equals("jump") || key.matches(CLIMBPATTERN)) {
            if (opened) {
                AudioPlayer.playEffect(47);
                Player.setOccupies(Id.ESC1);
                return "You climb down the ladder a ways into a small noisy tunnel.";
            }
            else {
                return "You aren't going anywhere with that grate closed.";
            }
        }
        else if (Patterns.KEY_P.matcher(key).matches()) {
            Player.setOccupies(key);
            return "You climb down the ladder a ways into a small noisy tunnel.";
        }
        else
            return getIt();
    }
    //-------------------------------------------------------------------------     
    @Override public String useEvent(Item item) {
        if (! opened) {
            AudioPlayer.playEffect(48);
            this.opened = true;
            return this.useDialog;
        }
        else
            return MOVED_GRATE;
    }
    //-------------------------------------------------------------------------     
    @Override public void reset() {
        this.opened = false;
    }
    //------------------------------------------------------------------------- 
    @Override public Direction getDir() {
        return Direction.DOWN;
    }
    //------------------------------------------------------------------------- 
}


