package Laboratory;

import A_Super.Furniture;
import A_Super.Item;
import A_Super.Openable;
/**
 * @author Kevin Rapa
 */
public class Labo_Shlf extends Furniture implements Openable {
    // ========================================================================
    public Labo_Shlf (Item... items) {
        super(items);
        
        this.description = "The metal shelf holds many different mysterious alchemical ingredients.";
        this.searchDialog = "You look on the shelves.";

        this.addNameKeys("(?:metal )?shelf");
    }
    // ========================================================================   
}


