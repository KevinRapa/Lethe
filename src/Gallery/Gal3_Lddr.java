package Gallery;

import Core.Player;
import Super.Staircase;
import Core.GUI;
import Super.Room;

public class Gal3_Lddr extends Staircase {
    private boolean lowered;
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gal3_Lddr(String NAME, Player player, char direction, int height) {
        super(NAME, player, direction, height);
        this.searchDialog = "The ladder hides nothing.";
        this.description = "The ladder is suspended above the ground in the\n"
                         + "hatch, too high to grab hold of.";
        this.lowered = false;
        this.NAMEKEYS.clear();
        this.addNameKeys("ladder");
    }
/*----------------------------------------------------------------------------*/     
    @Override public String getDescription() {
        String rep = this.description;
        
        if (this.lowered) {
            rep = "With the rope cut, the ladder now gives way to the\n"
                + "gallery loft.";
        }
        return rep;
    }
/*----------------------------------------------------------------------------*/
    public void lower() {
        this.lowered = true;
    }
/*----------------------------------------------------------------------------*/
    @Override public String interact(Room[][][] map, String key) {     
        String rep;
        
        if (this.lowered) {
            // Sets the room that the player is in.
            int[] c = REF.getOcc().getCoords(); // coordinates of player location.
            int Z = c[0]; int Y = c[1]; int X = c[2]; //Individual ZYX coordinates.
            int m = this.DIR == 'u' ? -this.HT : this.HT; // Z coordinate modifier.
                
            this.REF.setOccupies(map[Z + m][Y][X]); // moves the player's Z coordinate.
        
            rep = "You climb the " + this + ".";       
           
            GUI.roomOut(REF.getOcc().triggeredEvent(map));
        }
        else
            rep = "The ladder is too high up to climb.";
        
        return rep;
    }
/*----------------------------------------------------------------------------*/
}
