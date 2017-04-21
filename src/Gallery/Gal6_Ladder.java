package Gallery;

import A_Main.AudioPlayer;
import A_Super.Direction;
import A_Super.Staircase;

public class Gal6_Ladder extends Staircase {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gal6_Ladder(Direction direction) {
        super(direction);
        this.searchDialog = "The ladder hides nothing.";
        this.description = "The ladder leads down the hatch into the room below.";
        this.NAMEKEYS.clear();
        this.addNameKeys("(?:wood(?:en)? )?ladder");
    }
//-----------------------------------------------------------------------------
    @Override protected void playEffect() {
        // For overriding. Some stairs aren't wooden.
        AudioPlayer.playEffect(16);
    }
//-----------------------------------------------------------------------------
}
