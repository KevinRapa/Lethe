package Gallery;

import A_Main.AudioPlayer;
import A_Super.Direction;
import A_Super.Staircase;

public class Gal6_Lddr extends Staircase {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gal6_Lddr(Direction direction, int height) {
        super(direction, height);
        this.searchDialog = "The ladder hides nothing.";
        this.description = "The ladder leads down the hatch into the room below.";
    }
/*----------------------------------------------------------------------------*/
    @Override protected void playEffect() {
        // For overriding. Some stairs aren't wooden.
        AudioPlayer.playEffect(16);
    }
}
