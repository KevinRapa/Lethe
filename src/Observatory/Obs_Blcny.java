package Observatory;

import A_Super.Furniture;
/**
 * @author Kevin Rapa
 */
public class Obs_Blcny extends Furniture {
    // ========================================================================
    public Obs_Blcny () {
        super();
        this.searchable = false;
        
        this.description = "One balcony to the east on the second level serves\n"
                         + "as the sole access point to the third floor. The\n"
                         + "third floor balcony starts at the northeast and curves\n"
                         + "around the west side of the room against the window.";

        this.addNameKeys("balcony", "balconies");
    }
    // ========================================================================    
}


