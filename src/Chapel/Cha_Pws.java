package Chapel;

import A_Super.Furniture;
import A_Super.Item;
/**
 * @author Kevin Rapa
 */
public class Cha_Pws extends Furniture {

    // ========================================================================
    public Cha_Pws (Item... items) {
        super(items);
        this.description = "Ten rows of uncomfortable pews fill the chapel nave.\n"
                         + "A walkway splits the rows in the rooms center.";
        this.actDialog = "These look quite uncomfortable though...";
        this.searchDialog = "Walk up and down the aisle, scanning the pews.";

        this.addNameKeys("(?:uncomfortable )?(?:wood(?:en)? )?pews?");
        this.addActKeys("sit", "relax", "lay");
    }
    // ========================================================================    
}


