package Cistern;

import A_Main.Player;
import static A_Main.NameConstants.METAL_BUCKET;
import A_Super.Furniture;
import A_Super.Item;
/**
 * @author Kevin Rapa
 */
public class Cis_Wtr extends Furniture {
    protected final Item WTR_BCKT;
    // ========================================================================
    public Cis_Wtr (Item wtr) {
        super();
        this.searchable = false;
        
        this.WTR_BCKT = wtr;
        
        this.description = "The water is stagnant and fills the room with a putrid smell.\n"
                         + "A skin of algae coats nearly all of it.";
        this.actDialog = "This water is looks and smells terrible. You aren't doing that.";
        this.searchDialog = "You aren't searching that.";
        this.useDialog = "You pick some of the water up in the bucket.";

        this.addNameKeys("(?:stagnant )?(?:(?:large)? body of )?(?:putrid |disgusting |smelly |awful )?(?:stagnant )?water");
        this.addActKeys("swim", "jump", "drink");
        this.addUseKeys(METAL_BUCKET);
    }
    // ======================================================================== 
    @Override public String useEvent(Item item) {
        Player.getInv().remove(item);
        Player.getInv().add(WTR_BCKT);
        
        return this.useDialog;
    }
    // ========================================================================     
}


