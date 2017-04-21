package Observatory;

import A_Super.Balcony;
/**
 * @author Kevin Rapa
 */
public class Obs_Balcony extends Balcony {
    //-------------------------------------------------------------------------
    public Obs_Balcony () {
        super();

        this.description = "One balcony to the east on the second level serves "
                         + "as the sole access point to the third floor. The "
                         + "third floor balcony starts at the northeast and curves "
                         + "around the west side of the room against the window.";

        this.addNameKeys("balcony", "balconies");
    }
    //-------------------------------------------------------------------------    
}


