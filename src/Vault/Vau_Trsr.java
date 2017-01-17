package Vault;

import A_Super.Furniture;
import A_Super.Item;
/**
 * @author Kevin Rapa
 */
public class Vau_Trsr extends Furniture {
    // ========================================================================
    public Vau_Trsr (Item... items) {
        super(items);
        
        this.description = "There's jewelry from many different cultures lying\n"
                         + "everywhere. You feel overwhelmed with wealth.";
        this.searchDialog = "You gleefully dig through the piles of treasure.";

        this.addNameKeys("(?:piles of )?(?:coins|jewels|treasure)",
                "piles", "jewelry", "gold");
    }
    // ======================================================================== 
}


