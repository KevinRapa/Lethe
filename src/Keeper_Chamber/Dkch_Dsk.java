package Keeper_Chamber;

import A_Super.Furniture;
import A_Super.Item;
/**
 * @author Kevin Rapa
 */
public class Dkch_Dsk extends Furniture {
    // ========================================================================
    public Dkch_Dsk (Item... items) {
        super(items);
        
        this.description = "The plain wooden table has no drawers and only\n"
                         + "bears some papers and gadgets on the surface.\n"
                         + "The chair sits pushed in under it.";
        this.searchDialog = "You look on the desk and chair surfaces.";

        this.addNameKeys("(?:plain )?(?:wooden )?(?:desk|chair|table)");
    }
    // ========================================================================  
}


