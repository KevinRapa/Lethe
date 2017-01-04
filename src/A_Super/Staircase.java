package A_Super;

import A_Main.AudioPlayer;
import A_Main.GUI;
import A_Main.Player;
        
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
        this.addNameKeys("stair(?:s|case)|steps");
    }
/*----------------------------------------------------------------------------*/
    @Override public String interact(String key) {     
        // Sets the room that the player is in.
        int[] c = Player.getOcc().getCoords(); // coordinates of player location.
        int Z = c[0], Y = c[1], X = c[2], //Individual ZYX coordinates.
            m = this.DIR == 'u' ? -this.HT : this.HT; // Z coordinate modifier.

        playEffect();
        Player.setOccupies(Z + m, Y, X); // moves the player's Z coordinate.

        GUI.roomOut(Player.getOcc().triggeredEvent());
        Player.describeRoom();
        
        return "You climb " + (DIR == 'd' ? "down" : "up") + " the stairs.";
    }
/*----------------------------------------------------------------------------*/
    protected void playEffect() {
        // For overriding. Some stairs aren't wooden.
        AudioPlayer.playEffect(15);
    }
/*----------------------------------------------------------------------------*/
}
