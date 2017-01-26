package Black_Staircase;

import A_Super.Furniture;
/**
 * @author Kevin Rapa
 */
public class Bls_Balcony extends Furniture {
    // ========================================================================
    public Bls_Balcony () {
        super();

        this.addActKeys("You grasp the railing, but there's no fear of falling, right?");
        this.description = "The iron upper-floor balcony is small and suspended from\n"
                         + "the ceiling against the east wall via several cables.";
        
        this.addActKeys("grab", "hold");
        this.addNameKeys("(?:iron )?(?:balcony|railing)");
    }
    // ========================================================================    
}


