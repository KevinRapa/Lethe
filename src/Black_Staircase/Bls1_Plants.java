package Black_Staircase;

import A_Super.Item;
import A_Super.PottedPlant;
/**
 * @author Kevin Rapa
 */
public class Bls1_Plants extends PottedPlant {
    // ========================================================================
    public Bls1_Plants (Item soil) {
        super(soil);

        this.description = "Many small potted trees and bushes decorate the\n"
                         + "atrium. They all look quite healthy and nurtured,\n"
                         + "to your pleasant surprise.";

        this.addNameKeys("plants?", "trees?", "bush(?:es)?");
    }
    // ========================================================================     
}


