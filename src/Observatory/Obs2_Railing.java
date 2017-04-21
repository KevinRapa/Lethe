package Observatory;

import A_Super.Furniture;
/**
 * @author Kevin Rapa
 */
public class Obs2_Railing extends Furniture {
    //-------------------------------------------------------------------------
    public Obs2_Railing () {
        super();

        this.description = "The railing is quite thin, and does not appear as "
                         + "though it can take much weight. Certainly not your "
                         + "weight, that is.";
        this.actDialog = "That is really not a very safe thing to do.";
        this.addNameKeys("(?:balcony )?railing");
        this.addActKeys("lean");
    }
    //-------------------------------------------------------------------------    
}


