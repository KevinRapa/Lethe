package Garden;

import A_Super.Item;
import static A_Main.Id.GCHS;
import A_Super.LockedContainer;
/**
 * @author Kevin Rapa
 */
public class Gar3_Chest extends LockedContainer {
    // ========================================================================
    public Gar3_Chest(Item... items) {
        super(GCHS, items);
        
        this.actDialog = "It takes a small bit of force, but the rusty key manages to open the chest.";
        this.description = "It's a wooden chest for the holding of gardening implements and other nonsense.";
        this.searchDialog = "To your dismay, the chest has been locked previously.";

        this.addNameKeys("(?:wooden )?(?:utility )?chest");
    }
    // ========================================================================    
}


