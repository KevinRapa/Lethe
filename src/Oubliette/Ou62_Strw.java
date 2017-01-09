package Oubliette;

import A_Super.Furniture;
import A_Super.Item;
/**
 * @author Kevin Rapa
 */
public class Ou62_Strw extends Furniture {
    // ========================================================================
    public Ou62_Strw (Item... items) {
        super(items);
        this.searchable = false;
        
        this.description = "It's just plain straw.";

        this.addNameKeys("straw", "hay");
    }
    // ======================================================================== 
}


