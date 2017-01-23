package Chapel;

import A_Super.Item;
import A_Super.SearchableFurniture;
/**
 * @author Kevin Rapa
 */
public class Cha_Pews extends SearchableFurniture {
    // ========================================================================
    public Cha_Pews (Item... items) {
        super(items);
        this.description = "Ten rows of uncomfortable pews fill the chapel nave.\n"
                         + "A walkway splits the rows in the room's center.";
        this.actDialog = "These look quite uncomfortable though...";
        this.searchDialog = "You walk up and down the aisle, scanning the pews.";

        this.addNameKeys("(?:uncomfortable )?(?:wood(?:en)? )?pews?");
        this.addActKeys("sit", "relax", "lay");
    }
    // ========================================================================    
}


