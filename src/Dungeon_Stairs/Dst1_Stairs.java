package Dungeon_Stairs;

import A_Main.AudioPlayer;
import A_Main.Id;
import A_Super.Staircase;
import A_Main.Player;
import A_Super.Direction;

public class Dst1_Stairs extends Staircase {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Dst1_Stairs(Direction direction) {
        super(direction);
        this.description = "The mossy stone spiral staircase winds down into\n"
                         + "the unknown.";
        this.actDialog = "The sense of dread is overwhelming.\n"
                    + "You can't bring yourself to climb down them.";
    }
/*----------------------------------------------------------------------------*/
    @Override public String interact(String key) {  
        if (Player.hasVisited(Id.SEW0)) {
            // Sets the room that the player is in.
            Player.move(this.DIR);
            AudioPlayer.playEffect(15);
            
            return "You circle down the steps. You can't sense how many levels,\n"
                 + "but it is not just one. After a short while, you reach a dark\n"
                 + "landing.";       
        }
        else
            return this.actDialog;
    }
/*----------------------------------------------------------------------------*/
}
