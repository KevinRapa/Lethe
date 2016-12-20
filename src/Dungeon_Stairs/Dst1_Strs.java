package Dungeon_Stairs;

import Super.Staircase;
import Main.Player;
import Super.Room;

public class Dst1_Strs extends Staircase {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Dst1_Strs(Player player, char direction, int height) {
        super(player, direction, height);
        this.description = "The mossy stone spiral staircase winds down into\n"
                         + "the unknown.";
        this.interactDialog = "The sense of dread is overwhelming.\n"
                    + "You can't bring yourself to climb down them.";
    }
/*----------------------------------------------------------------------------*/
    @Override public String interact(Room[][][] map, String key) {  
        String rep;
        
        if (this.REF.hasVisited("DST2")) {
            // Sets the room that the player is in.
            int[] c = REF.getOcc().getCoords(); // coordinates of player location.
            int Z = c[0]; int Y = c[1]; int X = c[2]; //Individual ZYX coordinates.
            int m = this.DIR == 'u' ? -this.HT : this.HT; // Z coordinate modifier.

            this.REF.setOccupies(map[Z + m][Y][X]); // moves the player's Z coordinate.

            rep = "You circle down the steps. You can't sense how many levels,\n"
                + "but it is not just one. After a short while, you reach a dark\n"
                + "landing.";       
        }
        else
            rep = this.interactDialog;
        
        return rep;
    }
/*----------------------------------------------------------------------------*/
}
