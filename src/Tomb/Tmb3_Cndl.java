package Tomb;

import static A_Main.NameConstants.HAND_TORCH;
import A_Super.Furniture;
import A_Super.Gettable;
/**
 * @author Kevin Rapa
 */
public class Tmb3_Cndl extends Furniture implements Gettable {
    // ========================================================================
    public Tmb3_Cndl () {
        super();
        
        this.description = "The candles stand in the wall niches without any base;\n"
                         + "only a collection of melted wax at the bottoms holds them\n"
                         + "upright. Puzzlingly, the candles still burn steadily,\n"
                         + "not appearing to melt the wax any further.";
        this.useDialog = "The torch is already lit, despite having been in your pocket all this time.";
        this.actDialog = "Ouch! Really hot! Why would you do that to yourself?";
        
        this.addUseKeys(HAND_TORCH);
        this.addActKeys(GETPATTERN);
        this.addActKeys(FEELPATTERN);
        this.addNameKeys("(?:standing )?(?:wax )?candles?");
    }
    // ======================================================================== 
    @Override public String interact(String key) {
        if (key.matches(FEELPATTERN))
            return this.actDialog;
        else
            return getIt();
    }
    // ========================================================================   
    @Override public String getIt() {
        return "The candles are melted to the surface. You can't pick any up.";
    }
    // ========================================================================  
}


