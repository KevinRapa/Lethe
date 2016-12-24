package Observatory;

import A_Main.AudioPlayer;
import A_Super.DoubleStaircase;

public class Obs2_Strs extends DoubleStaircase {
/* CONSTRUCTOR ---------------------------------------------------------------*/     
    public Obs2_Strs() {
        super();
        this.description = "On each end of the balcony is a set of spiral stairs.\n"
                         + "One to the north leads to a third-floor balcony. The other\n"
                         + "to the south leads back down.";
        this.addNameKeys("spiral stair(?:s|case)");
    }
/*----------------------------------------------------------------------------*/  
    @Override protected void playEffect() {
        AudioPlayer.playEffect(14);
    }
/*----------------------------------------------------------------------------*/
}
