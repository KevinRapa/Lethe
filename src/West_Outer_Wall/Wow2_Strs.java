package West_Outer_Wall;

import Core.Player;
import Super.Staircase;
import Super.Room;

public class Wow2_Strs extends Staircase {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Wow2_Strs(String NAME, Player player, char direction, int height) {
        super(NAME, player, direction, height);
        this.searchDialog = "The ladder hides nothing.";
        this.description = "The ladder rests against the upper balcony, but it's\n"
                         + "unstable from the debris.";
        this.NAMEKEYS.clear();
        this.addNameKeys("ladder", "fixed ladder");
    }
/*----------------------------------------------------------------------------*/ 
    @Override public String interact(Room[][][] map, String key) {     
        // Sets the room that the player is in.
        int[] c = REF.getOcc().getCoords(); // coordinates of player location.
        int Z = c[0]; int Y = c[1]; int X = c[2]; //Individual ZYX coordinates.
        int m = this.DIR == 'u' ? -this.HT : this.HT; // Z coordinate modifier.
                
        this.REF.setOccupies(map[Z + m][Y][X]); // moves the player's Z coordinate.
        
        String rep = "You climb the " + this + ". " + REF.getOcc().triggeredEvent(map);       

        REF.describeRoom();
        
        return rep;
    }
/*----------------------------------------------------------------------------*/
}
