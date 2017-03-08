package Garden;

import A_Super.Item;
import A_Super.Openable;
import A_Super.SearchableFurniture;
import static A_Main.Id.GCHS;
/**
 * @author Kevin Rapa
 */
public class Gar3_Chest extends LockedCabinet {
    // ========================================================================
    public Gar3_Chest (Item... items) {
        super(GCHS, items);
        
        this.actDialog = "It takes a small bit of force, but the rusty key manages to open the chest.";
        this.description = "It's a wooden chest for the holding of gardening implements and other nonsense.";
        this.searchDialog = "To your dismay, the chest has been locked previously.";

        this.addNameKeys("(?:wooden )?(?:utility )?chest");
    }
    // ========================================================================    
}


