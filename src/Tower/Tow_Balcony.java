package Tower;

import A_Super.Balcony;
/**
 * @author Kevin Rapa
 */
public class Tow_Balcony extends Balcony {
    // ========================================================================
    public Tow_Balcony () {
        super();
        
        this.description = "The long circular balcony wraps around the inner\n"
                         + "perimeter of the upper tower floor. A black metal\n"
                         + "railing guards the balcony's inner edge.";

        this.addNameKeys("(?:long )?(?:circular )?balcony", "(?:black )?(?:metal )?railing");
    }
    // ========================================================================    
}


