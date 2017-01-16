package Black_Staircase;

import A_Super.Furniture;
/**
 * @author Kevin Rapa
 */
public class Bls_Blcny extends Furniture {
    // ========================================================================
    public Bls_Blcny () {
        super();
        this.searchable = false;

        this.description = "The iron upper-floor balcony is small and suspended from\n"
                         + "the ceiling against the east wall via several cables.";
        
        this.addNameKeys("(?:iron )?(?:balcony|railing)");
    }
    // ========================================================================    
}


