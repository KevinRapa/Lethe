package A_Super;

import A_Main.AudioPlayer;
import static A_Main.NameConstants.WEAPON;
import A_Main.Player;

public class Door extends Furniture {
    protected final Direction DIR; 
/* CONSTRUCTOR ---------------------------------------------------------------*/     
    public Door (Direction dir) {
        super();
        this.DIR = dir;
        this.useDialog = "...Do you intend to pick the lock with that? Well,\n"
                       + "perhaps you could, but then again, you are not learned\n"
                       + "of this skill. Yet another you yearn for at the moment.";
        this.searchDialog = "You aren't sure what you'd search for on a door.";
        this.description = "It looks like a heavy wooden door.";
        this.actDialog = null;

        this.addUseKeys(ANYTHING);
        this.addActKeys("open|use|walk|go|close", "kick|bash|break", "knock|bang", "unlock|lock");
        this.addNameKeys(dir + " door", "(?:heavy )?(?:wooden )?door");
    }
/*----------------------------------------------------------------------------*/    
    @Override public String interact(String key) {
        if (key.equals("close"))
            return "The door is already closed.";
        else if (key.equals("kick") || key.equals("break") || key.equals("bash")) {
            AudioPlayer.playEffect(40);
            return "You thrust your boot into the door, but the door is too\n" +
                   "well-built to give.";
        }
        else if (key.equals("knock") || key.equals("bang")) {
            AudioPlayer.playEffect(55);
            return "You give the door a knock. To your astonishment, your knock is left unanswered.";
        }
        else if (key.equals("lock") || key.equals("unlock")) {
            return "That isn't how this game works. Read the directions!";
        }
        else {
            Player.move(DIR);
            return this.actDialog;
        }
    } 
/*----------------------------------------------------------------------------*/
    @Override public String useEvent(Item item) {
        if (item.getType().equals(WEAPON)) 
            return "The door is build too solidly and breaking it down is futile.";
        else
            return this.useDialog;
        
    }
/*----------------------------------------------------------------------------*/
}
