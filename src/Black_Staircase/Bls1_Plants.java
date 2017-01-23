package Black_Staircase;

import A_Super.Furniture;
/**
 * @author Kevin Rapa
 */
public class Bls1_Plants extends Furniture {
    // ========================================================================
    public Bls1_Plants () {
        super();

        this.description = "Many small potted trees and bushes decorate the\n"
                         + "atrium. They all look quite healthy and nurtured,\n"
                         + "to your pleasant surprise.";
        this.searchDialog = "You fail to find anything of interest.";

        this.addNameKeys("plants?", "trees?", "bush(?:es)?");
    }
    // ========================================================================     
}


