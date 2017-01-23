package Garden;

import A_Super.Item;
import A_Super.Openable;
import A_Super.SearchableFurniture;
/**
 * @author Kevin Rapa
 */
public class Gar3_Chest extends SearchableFurniture implements Openable {
    // ========================================================================
    public Gar3_Chest (Item... items) {
        super(items);
        
        this.description = "It's a wooden chest for the holding of gardening implements and other nonsense.";
        this.searchDialog = "You open the chest and peer inside.";

        this.addNameKeys("(?:wooden )?(?:utility )?chest");
    }
    // ========================================================================    
}


