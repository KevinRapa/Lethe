package Lichs_Quarters;

import A_Super.Furniture;
import A_Super.Item;
import A_Super.Openable;
/**
 * @author Kevin Rapa
 */
public class Lqu1_Cabinet extends Furniture implements Openable {
    // ========================================================================
    public Lqu1_Cabinet (Item... items) {
        super(items);
        
        this.description = "It's a standing glass cabinet for displaying\n"
                         + "weaponry, staffs, brooms, bedposts; long objects.";

        this.searchDialog = "You open the cabinet and look inside.";

        this.addNameKeys("(?:tall )?(?:standing )?(?:glass )?(?:display )?(?:cabinet|case)", 
                "(?:tall )?(?:standing )?(?:glass )?display");
    }
    // ========================================================================    
}


