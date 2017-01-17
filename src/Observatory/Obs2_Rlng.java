package Observatory;

import A_Super.Furniture;
/**
 * @author Kevin Rapa
 */
public class Obs2_Rlng extends Furniture {

    // ========================================================================
    public Obs2_Rlng () {
        super();
        this.searchable = false;
        this.description = "The railing is quite thin, and does not appear as\n"
                         + "though it can take much weight. Certainly not your\n"
                         + "weight, that is.";
        this.actDialog = "That is really not a very safe thing to do.";
        this.addNameKeys("(?:balcony )?railing");
        this.addActKeys("lean");
    }
    // ========================================================================    
}


