package Super;

import Main.AudioPlayer;
import Main.GUI;
import Main.Player;
        
public class Staircase extends Furniture {
    protected final char DIR;
    protected final int HT;
/* CONSTRUCTOR ---------------------------------------------------------------*/        
    public Staircase(char direction, int height) {
        super();
        this.searchable = false;
        this.DIR = direction;
        this.HT = height;
        this.addActKeys("climb", "use", "walk");
        this.addNameKeys("stairs", "steps", "staircase");
    }
/*----------------------------------------------------------------------------*/
    @Override public String interact(String key) {     
        // Sets the room that the player is in.
        int[] c = Player.getOcc().getCoords(); // coordinates of player location.
        int Z = c[0]; int Y = c[1]; int X = c[2]; //Individual ZYX coordinates.
        int m = this.DIR == 'u' ? -this.HT : this.HT; // Z coordinate modifier.

        playEffect();
        Player.setOccupies(Z + m, Y, X); // moves the player's Z coordinate.
        
        String rep = "You climb " + (DIR == 'd' ? "down" : "up") + " the stairs.";       

        GUI.roomOut(Player.getOcc().triggeredEvent());
        Player.describeRoom();
        
        return rep;
    }
/*----------------------------------------------------------------------------*/
    protected void playEffect() {
        // For overriding. Some stairs aren't wooden.
        AudioPlayer.playEffect(15);
    }
/*----------------------------------------------------------------------------*/
}
