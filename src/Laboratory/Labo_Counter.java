package Laboratory;

import A_Super.Item;
import A_Super.Openable;
import A_Super.SearchableFurniture;
import A_Super.Unmoveable;
/**
 * @author Kevin Rapa
 */
public class Labo_Counter extends SearchableFurniture implements Openable, Unmoveable {
    // ========================================================================
    public Labo_Counter (Item... items) {
        super(items);
        
        this.description = "The counter has a black top and two drawers on the bottom. "
                         + "On the surface of the counter, to the left, is a metal sink "
                         + "next to the large contraption on the right.";
        this.searchDialog = "You look inside the drawers.";

        this.addNameKeys("counter", "drawers?");
    }
    // ========================================================================      
}


