package Lichs_Quarters;

import A_Super.Furniture;
import A_Super.Item;
import A_Super.Openable;
/**
 * @author Kevin Rapa
 */
public class Lqu1_Wrdrb extends Furniture implements Openable {

    // ========================================================================
    public Lqu1_Wrdrb (Item... items) {
        super(items);
        
        this.description = "It's a tall blue wooden wardrobe accented in yellow.";
        this.searchDialog = "You open up the wardrobe.";

        this.addNameKeys("(?:tall )?(?:blue )?(?:wooden )?wardrobe");
    }
    // ========================================================================      
}


