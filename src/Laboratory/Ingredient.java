package Laboratory;

import A_Main.ItemTypeConstants;
import A_Super.Item;

/**
 * Used in the laboratory.
 * Ingredients can be added to the florence flask in the laboratory.
 * 
 * @see Laboratory.Labo_Flsk
 * @author Kevin Rapa
 */
public class Ingredient extends Item {
    // ========================================================================
    public Ingredient(String name, String desc) {
        super(name, desc);
        this.type = ItemTypeConstants.INGREDIENT;
    }
    // ========================================================================
}
