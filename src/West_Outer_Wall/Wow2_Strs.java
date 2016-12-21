package West_Outer_Wall;

import Main.AudioPlayer;
import Main.Player;
import Super.Staircase;

public class Wow2_Strs extends Staircase {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Wow2_Strs(char direction, int height) {
        super(direction, height);
        this.searchDialog = "The ladder hides nothing.";
        this.description = "The ladder rests against the upper balcony, but it's\n"
                         + "unstable from the debris.";
        this.NAMEKEYS.clear();
        this.addNameKeys("ladder", "fixed ladder");
    }
/*----------------------------------------------------------------------------*/ 
    @Override public String interact(String key) {     
        // Sets the room that the player is in.
        int[] c = Player.getOcc().getCoords(); // coordinates of player location.
        int Z = c[0]; int Y = c[1]; int X = c[2]; //Individual ZYX coordinates.
        int m = this.DIR == 'u' ? -this.HT : this.HT; // Z coordinate modifier.
                
        Player.setOccupies(Z + m, Y, X); // moves the player's Z coordinate.
        
        playEffect();
        String rep = "You climb the ladder. " + Player.getOcc().triggeredEvent();       

        Player.describeRoom();
        
        return rep;
    }
/*----------------------------------------------------------------------------*/
    @Override protected void playEffect() {
        // For overriding. Some stairs aren't wooden.
        AudioPlayer.playEffect(16);
    }
}
