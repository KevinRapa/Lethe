package West_Outer_Wall;

import A_Main.AudioPlayer;
import A_Main.Player;
import A_Super.Staircase;
import A_Super.Direction;

public class Wow2_Strs extends Staircase {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Wow2_Strs(Direction direction, int height) {
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
        int[] c = Player.getPos().getCoords(); // coordinates of player location.
                
        Player.setOccupies(c[0] + DIR.Z, c[1], c[2]); // moves the player's Z coordinate.
        
        playEffect();
        Player.describeRoom();
        
        return Player.getPos().triggeredEvent();       
    }
/*----------------------------------------------------------------------------*/
    @Override protected void playEffect() {
        // For overriding. Some stairs aren't wooden.
        AudioPlayer.playEffect(16);
    }
/*----------------------------------------------------------------------------*/
}
