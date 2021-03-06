package Kampe_Quarters;

import A_Super.Item;
import A_Super.Moveable;
import A_Super.SearchableFurniture;
/**
 * @author Kevin Rapa
 */
public class Dkch_Desk extends SearchableFurniture implements Moveable {
    //-------------------------------------------------------------------------
    public Dkch_Desk (Item... items) {
        super(items);
        
        this.description = "The plain wooden table has no drawers and only "
                         + "bears some papers and gadgets on the surface. "
                         + "The chair sits pushed in under it.";
        this.searchDialog = "You look on the desk and chair surfaces.";

        this.addNameKeys("(?:plain )?(?:wooden )?(?:desk|chair|table)");
    }
    //-------------------------------------------------------------------------  
}


