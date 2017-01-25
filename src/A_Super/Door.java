package A_Super;

import A_Main.AudioPlayer;
import A_Main.Player;

public class Door extends Furniture {
    protected final Direction DIR; 
/* CONSTRUCTOR ---------------------------------------------------------------*/     
    public Door (Direction dir) {
        super();
        this.DIR = dir;
        this.useDialog = "You have no idea how to pick a lot. And do you really think that will fit in there?";
        this.searchDialog = "You aren't sure what you'd search for on a door.";
        this.description = "It looks like a heavy wooden door.";
        this.actDialog = null;

        this.addUseKeys(".+");
        this.addActKeys("open", "use", "close", "kick", "knock|bang", "unlock", "lock");
        this.addNameKeys(dir + " door", "door", "(?:heavy )?(?:wooden )?door");
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
        else if (key.matches("knock|bang")) {
            return "You're a guest here, remember?";
        }
        else if (key.matches("unlock|lock")) {
            return "That's not how this game works. Read the directions!";
        }
        else {
            Player.move(DIR);
            return this.actDialog;
        }
    } 
/*----------------------------------------------------------------------------*/ 
}
