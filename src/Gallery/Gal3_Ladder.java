package Gallery;

import A_Main.AudioPlayer;
import A_Main.Player;
import A_Super.Staircase;
import A_Super.Direction;

public class Gal3_Ladder extends Staircase {
    private boolean lowered;
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gal3_Ladder(Direction direction) {
        super(direction);

        this.description = "The ladder is suspended above the ground in the "
                         + "hatch, too high to grab hold of.";
        this.lowered = false;
        this.NAMEKEYS.clear();
        this.addNameKeys("ladder");
    }
/*----------------------------------------------------------------------------*/     
    @Override public String getDescription() {
        return (! this.lowered) ? this.description :
            "With the rope cut, the ladder now gives way to the gallery loft.";
    }
/*----------------------------------------------------------------------------*/
    public void lower() {
        this.lowered = true;
    }
/*----------------------------------------------------------------------------*/
    @Override public String interact(String key) {     
        if (this.lowered) {
            Player.move(this.DIR);
            playEffect();
            
            return "You climb the ladder.";   
        }
        else
            return "The ladder is too high up to climb.";
    }
/*----------------------------------------------------------------------------*/
    @Override protected void playEffect() {
        AudioPlayer.playEffect(16);
    }
/*----------------------------------------------------------------------------*/
}
