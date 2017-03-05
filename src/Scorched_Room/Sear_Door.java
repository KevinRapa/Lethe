package Scorched_Room;

import A_Main.AudioPlayer;
import static A_Main.NameConstants.WEAPON;
import A_Super.Furniture;
import A_Super.Item;

public class Sear_Door extends Furniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/        
    public Sear_Door () {
        super();

        this.useDialog = "...Do you intend to pick the lock with that? Well,\n"
                       + "perhaps you could, but then again, you are not learned\n"
                       + "of this skill. Yet another you yearn for at the moment.";
        this.description = "The door is in even worse condition from this side.\n"
                         + "Whoever it is lying there was hitting it very\n"
                         + "forcefully with that crowbar to break it down.";
        this.actDialog = "There's enough evidence here to suggest you can't go\n"
                       + "through there.";
        this.addUseKeys(ANYTHING);
        this.addNameKeys("west door", "door");
        this.addActKeys("open|use|walk|go|close|kick", "knock|bang", "unlock|lock");
    }
/*----------------------------------------------------------------------------*/
    @Override public String interact(String key) {
        if (key.equals("close"))
            return "The door is already closed.";
        else if (key.equals("kick")) {
            AudioPlayer.playEffect(40);
            return "You thrust your boot into the door, but the door is too\n" +
                   "well-built to give.";
        }
        else if (key.equals("knock") || key.equals("bang")) {
            AudioPlayer.playEffect(55);
            return "You give the door a knock. To your astonishment, your knock is left unanswered.";
        }
        else if (key.equals("lock") || key.equals("unlock"))
            return "That isn't how this game works. Read the directions!";
        else 
            return this.actDialog;
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
