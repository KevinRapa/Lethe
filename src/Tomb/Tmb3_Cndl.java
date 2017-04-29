package Tomb;

import static A_Main.Names.HAND_TORCH;
import A_Super.Furniture;
import A_Super.Gettable;
/**
 * @author Kevin Rapa
 */
public class Tmb3_Cndl extends Furniture implements Gettable {
    //-------------------------------------------------------------------------
    public Tmb3_Cndl () {
        super();
        
        this.description = "The candles stand in the wall niches without any base; "
                         + "only a collection of melted wax at the bottoms holds them "
                         + "upright. Perplexingly, the candles still burn steadily, "
                         + "not appearing to melt the wax any further.";
        this.useDialog = "The torch is already lit, despite having been in your pocket all this time.";
        this.actDialog = "Ouch! Really hot! Why would you do that to yourself?";
        
        this.addUseKeys(HAND_TORCH);
        this.addActKeys(GETPATTERN, FEELPATTERN);
        this.addNameKeys("(?:standing )?(?:wax )?candles?");
    }
    //------------------------------------------------------------------------- 
    @Override public String interact(String key) {
        if (key.matches(FEELPATTERN))
            return this.actDialog;
        else
            return getIt("The candles are melted to the surface. You can't pick any up.");
    }
    //-------------------------------------------------------------------------    
}


