package A_Super;

import A_Main.AudioPlayer;
import static A_Main.Names.WEAPON;
import static A_Main.Patterns.DESTROY_P;
import A_Main.Player;

public class Door extends Furniture {
    protected final Direction DIR; 
/* CONSTRUCTOR ---------------------------------------------------------------*/     
    public Door (Direction dir) {
        super();
        this.DIR = dir;
        this.useDialog = "You are not skilled in lock picking";
        this.searchDialog = "You aren't sure what you'd search for.";
        this.description = "It looks like a heavy wooden door.";
        
        this.addUseKeys(ANYTHING);
        this.addActKeys("open|use|walk|go|close", 
                "kick|bash|break|obliterate|destroy", "knock|bang", "unlock|lock", "pick");
        this.addNameKeys(dir + " door", "(?:heavy )?(?:wooden )?door", "(?:door )?lock");
        
        if (dir == Direction.EAST)
            this.addNameKeys("right door");
        else if (dir == Direction.WEST)
            this.addNameKeys("left door");
    }
//-----------------------------------------------------------------------------    
    @Override public String interact(String key) {
        if (key.equals("close"))
            return "The door is already closed.";
        else if (DESTROY_P.matcher(key).matches() 
                || key.equals("kick") || key.equals("bash")) 
        {
            AudioPlayer.playEffect(40);
            return "You thrust your boot into the door, but the door is too " +
                   "well-built to give.";
        }
        else if (key.equals("knock") || key.equals("bang")) {
            AudioPlayer.playEffect(55);
            return "You give the door a knock. Your knock is left unanswered.";
        }
        else if (key.equals("lock")) {
            return "There is no point in locking the door";
        }
        else if (key.equals("unlock")) {
            return "Attempting to move into the next room will accomplish that.";
        }
        else if (key.equals("pick")) {
            return "Lock picking is a skill you have always yearned for.";
        }
        else {
            Player.move(DIR);
            return NOTHING;
        }
    } 
//-----------------------------------------------------------------------------
    @Override public String useEvent(Item item) {
        if (item.getType().equals(WEAPON)) 
            return "The door is build too solidly and breaking it down is futile.";
        else
            return this.useDialog;
        
    }
//-----------------------------------------------------------------------------
}
