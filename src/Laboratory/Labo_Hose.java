package Laboratory;

import A_Super.Furniture;
import A_Super.Item;
/**
 * @author Kevin Rapa
 */
public class Labo_Hose extends Furniture {
    // ========================================================================
    public Labo_Hose (Item... items) {
        super(items);
        this.searchable = false;
        
        this.description = "The yellow rubber hose connects the gas pipe to the bunsen burner.";

        this.addNameKeys("(?:yellow )?(?:rubber )?hose");
    }
    // ======================================================================== 
}


