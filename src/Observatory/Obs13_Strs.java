package Observatory;

import A_Main.AudioPlayer;
import A_Super.Direction;
import A_Super.Staircase;

public class Obs13_Strs extends Staircase {
/* CONSTRUCTOR ---------------------------------------------------------------*/     
    public Obs13_Strs (Direction direction, int height) {
        super(direction, height);
        this.description = "The spiral staircase sits in a round alcove carved\n"
                         + "into the wall to the southeast and leads up to a long,\n"
                         + "wide balcony on the second floor.";
        this.addNameKeys("spiral stair(?:s|case)");
    }
/*----------------------------------------------------------------------------*/
    @Override public String getDescription() {
        String rep = this.description;
        
        if (this.DIR == Direction.DOWN) {
            rep = "The spiral staircase sits in a round alcove carved\n"
                + "into the wall to the southeast and leads down to the first\n"
                + "floor.";
        }
        return rep;
    }
/*----------------------------------------------------------------------------*/
    @Override protected void playEffect() {
        AudioPlayer.playEffect(14);
    }
/*----------------------------------------------------------------------------*/
}

