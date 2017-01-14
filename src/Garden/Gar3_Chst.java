package Garden;

import A_Super.Furniture;
import A_Super.Item;
import A_Super.Openable;
/**
 * @author Kevin Rapa
 */
public class Gar3_Chst extends Furniture implements Openable {
    // ========================================================================
    public Gar3_Chst (Item... items) {
        super(items);
        
        this.description = "It's a wooden chest for the holding of gardening implements and other nonsense.";
        this.searchDialog = "You open the chest and peer inside.";

        this.addNameKeys("wooden chest", "chest", "utility chest");
    }
    // ========================================================================    
}


