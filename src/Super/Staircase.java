package Super;

import Core.GUI;
import Core.Player;
        
public class Staircase extends Furniture {
    protected final Player REF;
    protected final char DIR;
    protected final int HT;
/* CONSTRUCTOR ---------------------------------------------------------------*/        
    public Staircase(String NAME, Player player, char direction, int height) {
        super(NAME);
        this.searchable = false;
        this.REF = player;
        this.DIR = direction;
        this.HT = height;
        this.addActKeys("climb", "use", "walk");
        this.addNameKeys("stairs", "steps", "staircase");
    }
/*----------------------------------------------------------------------------*/
    @Override public String interact(Room[][][] map, String key) {     
        // Sets the room that the player is in.
        int[] c = REF.getOcc().getCoords(); // coordinates of player location.
        int Z = c[0]; int Y = c[1]; int X = c[2]; //Individual ZYX coordinates.
        int m = this.DIR == 'u' ? -this.HT : this.HT; // Z coordinate modifier.
                
        this.REF.setOccupies(map[Z + m][Y][X]); // moves the player's Z coordinate.
        
        String rep = "You climb the " + this + ".";       

        GUI.roomOut(REF.getOcc().triggeredEvent(map));
        REF.describeRoom();
        
        return rep;
    }
/*----------------------------------------------------------------------------*/
}
