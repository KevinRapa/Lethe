package Kampe_Quarters;

import A_Super.Item;
import A_Super.Moveable;
import A_Super.SearchableFurniture;
/**
 * @author Kevin Rapa
 */
public class Dkch_Bed extends SearchableFurniture implements Moveable {
    // ========================================================================
    public Dkch_Bed (Item... items) {
        super(items);
        
        this.description = "A cheap spring bed with no sheets, only a plain dirty mattress.";
        this.actDialog = "Whoever owns this probably doesn't want you doing that...";
        this.searchDialog = "You look under the bed.";

        this.addNameKeys("(?:cheap )?(?:spring )?bed", "(?:plain )?(?:dirty )?mattress");
        this.addActKeys(SITPATTERN);
    }
    // ======================================================================== 
}


