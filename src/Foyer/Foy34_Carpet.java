package Foyer;

import A_Super.Furniture;
import A_Super.Item;
/**
 * @author Kevin Rapa
 */
public class Foy34_Carpet extends Furniture {
    // ========================================================================
    public Foy34_Carpet (Item... items) {
        super(items);
        this.searchable = false;
        
        this.description = "The thick red carpet runner follows up and down\n"
                         + "the foyer stairscase.";
        this.searchDialog = "There's nothing under the carpet runner.";

        this.addNameKeys("rug", "carpet(?: runner)?");
    }
    // ======================================================================== 
}


