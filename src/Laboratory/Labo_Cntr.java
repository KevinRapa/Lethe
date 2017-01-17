package Laboratory;

import A_Super.Furniture;
import A_Super.Item;
import A_Super.Openable;
/**
 * @author Kevin Rapa
 */
public class Labo_Cntr extends Furniture implements Openable {
    // ========================================================================
    public Labo_Cntr (Item... items) {
        super(items);
        
        this.description = "The counter has a black top and two drawers on the bottom.\n"
                         + "On the surface of the counter, to the left, is a metal sink\n"
                         + "next to the large contraption on the right.";
        this.searchDialog = "You look inside the drawers.";

        this.addNameKeys("counter", "drawers?");
    }
    // ========================================================================      
}


