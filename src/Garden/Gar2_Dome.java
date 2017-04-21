package Garden;

import static A_Main.Names.*;
import A_Super.Furniture;
import A_Super.Unmoveable;
/**
 * @author Kevin Rapa
 */
public class Gar2_Dome extends Furniture implements Unmoveable {
    //-------------------------------------------------------------------------
    public Gar2_Dome () {
        super();

        this.description = "The paneled dome must be there to prevent rain from "
                         + "dripping into the room below. Still, why have a hole "
                         + "there in the first place?";
        this.useDialog = 
        this.actDialog = "If you do that, the glass will probably rain "
                       + "rain down on you as a deadly shower of glass.";

        this.addUseKeys(STONE_BLOCK, RED_BALL, CUE_BALL, ROCK);
        this.addActKeys("shatter");
        this.addNameKeys("(?:paneled )?(?:glass )?dome");
    }
    //------------------------------------------------------------------------- 
}


