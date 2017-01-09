package Tomb;

import A_Super.Furniture;
/**
 * @author Kevin Rapa
 */
public class Tmb3_Cndl extends Furniture {

    // ========================================================================
    public Tmb3_Cndl () {
        super();
        this.searchable = false;
        
        this.description = "The candles stand in the wall niches without any base;\n"
                         + "only a collection of melted wax at the bottom holds it\n"
                         + "upright. Puzzlingly, the candle still burns steadily and\n"
                         + "is not appearing to melt the wax any further.";

        this.addNameKeys("(?:standing )?(?:wax )?candles?");
    }
    // ========================================================================   
}


