package Black_Staircase;

import A_Super.Balcony;
/**
 * @author Kevin Rapa
 */
public class Bls_Balcony extends Balcony {
    //-------------------------------------------------------------------------
    public Bls_Balcony () {
        super();

        this.description = "The iron upper-floor balcony is small and suspended from "
                         + "the ceiling against the east wall via several cables.";
        
        this.addNameKeys("(?:iron )?(?:balcony|railing)");
    }
    //-------------------------------------------------------------------------    
}


