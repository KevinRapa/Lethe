package Laboratory;

import A_Super.Container;
import A_Super.Furniture;
import A_Super.Item;
/**
 * @author Kevin Rapa
 */
public class Labo_Shlf extends Furniture implements Container {
    // ========================================================================
    public Labo_Shlf (Item... items) {
        super(items);
        
        this.description = "The metal shelf is holds many different mysterious alchemical ingredients.";
        this.searchDialog = "The look on the shelves.";

        this.addNameKeys("shelf", "metal shelf");
    }
    // ========================================================================   
}


