package Lichs_Quarters;

import A_Super.Item;
import A_Super.Openable;
import A_Super.SearchableFurniture;
/**
 * @author Kevin Rapa
 */
public class Lqu1_Wardrobe extends SearchableFurniture implements Openable {
    // ========================================================================
    public Lqu1_Wardrobe (Item... items) {
        super(items);
        
        this.description = "It's a tall blue wooden wardrobe accented in yellow.";
        this.searchDialog = "You open up the wardrobe.";

        this.addNameKeys("(?:tall )?(?:blue )?(?:wooden )?wardrobe");
    }
    // ========================================================================      
}


