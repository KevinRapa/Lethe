package Secret_Stairs;

import A_Main.AudioPlayer;
import A_Super.Staircase;

public class Sst_Strs extends Staircase {
/* CONSTRUCTOR ---------------------------------------------------------------*/     
    public Sst_Strs (char direction, int height) {
        super(direction, height);
        this.description = "The rickety U-shaped wooden staircase wraps around\n"
                         + "the room to a small second-floor landing. It looks\n"
                         + "only partially stable.";
        this.addNameKeys("(?:rickety )?(?:wooden )?(?:stair(?:s|case)|steps)");
    }
/*----------------------------------------------------------------------------*/
    @Override public String getDescription() {
        String rep = this.description;
        
        if (this.DIR == 'd') {
            rep = "The rickety wooden stairs lead back down to the second floor.";
        }
        return rep;
    }
/*----------------------------------------------------------------------------*/
    @Override protected void playEffect() {
        AudioPlayer.playEffect(14);
    }
/*----------------------------------------------------------------------------*/
}


