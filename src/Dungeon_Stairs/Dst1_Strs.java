package Dungeon_Stairs;

import A_Main.AudioPlayer;
import A_Super.Staircase;
import A_Main.Player;
import A_Super.Direction;

public class Dst1_Strs extends Staircase {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Dst1_Strs(Direction direction, int height) {
        super(direction, height);
        this.description = "The mossy stone spiral staircase winds down into\n"
                         + "the unknown.";
        this.actDialog = "The sense of dread is overwhelming.\n"
                    + "You can't bring yourself to climb down them.";
    }
/*----------------------------------------------------------------------------*/
    @Override public String interact(String key) {  
        if (Player.hasVisited("SEW0")) {
            // Sets the room that the player is in.
            int[] c = Player.getPos().getCoords(); // coordinates of player location.

            Player.setOccupies(c[0] + DIR.Z, c[1], c[2]); // moves the player's Z coordinate.
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
