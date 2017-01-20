package Secret_Stairs;

import A_Main.AudioPlayer;
import A_Super.Direction;
import A_Super.Staircase;

public class Sst_Stairs extends Staircase {
/* CONSTRUCTOR ---------------------------------------------------------------*/     
    public Sst_Stairs (Direction direction) {
        super(direction);
        this.description = "The rickety U-shaped wooden staircase wraps around\n"
                         + "the room to a small second-floor landing. It looks\n"
                         + "only partially stable.";
        this.addNameKeys("(?:rickety )?(?:wooden )?(?:stair(?:s|case)|steps)");
    }
/*----------------------------------------------------------------------------*/
    @Override public String getDescription() {
        if (this.DIR == Direction.DOWN) {
            return "The rickety wooden stairs lead back down to the second floor.";
        }
        return this.description;
    }
/*----------------------------------------------------------------------------*/
    @Override protected void playEffect() {
        AudioPlayer.playEffect(14);
    }
/*----------------------------------------------------------------------------*/
}


