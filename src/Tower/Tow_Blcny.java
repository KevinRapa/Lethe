package Tower;

import A_Super.Furniture;
/**
 * @author Kevin Rapa
 */
public class Tow_Blcny extends Furniture {
    // ========================================================================
    public Tow_Blcny () {
        super();
        this.searchable = false;
        
        this.description = "The long circular balcony wraps around the inner\n"
                         + "perimeter of the upper tower floor. A black metal\n"
                         + "railing gaurds the balcony's inner edge.";
        this.actDialog = "And fall to your death?";

        this.addNameKeys("(?:long )?(?:circular )?balcony", "(?:black )?(?:metal )?railing");
        this.addActKeys("jump");
    }
    // ========================================================================    
}


