package Foyer;

import A_Super.Furniture;
/**
 * @author Kevin Rapa
 */
public class Foy34_Carpet extends Furniture {
    // ========================================================================
    public Foy34_Carpet () {
        super();
        
        this.description = "The thick red carpet runner follows up and down\n"
                         + "the foyer stairscase.";
        this.searchDialog = "There's nothing under the carpet runner.";

        this.addNameKeys("rug", "carpet(?: runner)?");
    }
    // ======================================================================== 
}


