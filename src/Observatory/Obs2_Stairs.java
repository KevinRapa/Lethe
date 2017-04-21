package Observatory;

import A_Main.AudioPlayer;
import A_Super.DoubleStaircase;

public class Obs2_Stairs extends DoubleStaircase {
/* CONSTRUCTOR ---------------------------------------------------------------*/     
    public Obs2_Stairs() {
        super();
        this.description = "On each end of the balcony is a set of spiral stairs. "
                         + "One to the north leads to a third-floor balcony. The other "
                         + "to the south leads back down.";
        this.addNameKeys("spiral stair(?:s|cases?)");
    }
//-----------------------------------------------------------------------------  
    @Override protected void playEffect() {
        AudioPlayer.playEffect(14);
    }
//-----------------------------------------------------------------------------
}
