package Keeper_Chamber;

import A_Super.Furniture;
import A_Super.Item;
/**
 * @author Kevin Rapa
 */
public class Dkch_Bd extends Furniture {
    // ========================================================================
    public Dkch_Bd (Item... items) {
        super(items);
        
        this.description = "A cheap spring bed with no sheets, only a plain dirty mattress.";
        this.actDialog = "Whoever owns this probably doesn't want you doing that...";
        this.searchDialog = "You look under the bed.";

        this.addNameKeys("(?:cheap )?(?:spring )?bed", "(?:plain )?(?:dirty )?mattress");
        this.addActKeys("sleep", "relax", "lay", "sit");
    }
    // ======================================================================== 
}


