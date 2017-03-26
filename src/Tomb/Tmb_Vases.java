package Tomb;

import A_Super.Item;
import A_Super.Moveable;
import A_Super.Openable;
import A_Super.SearchableFurniture;
/**
 * @author Kevin Rapa
 */
public class Tmb_Vases extends SearchableFurniture implements Openable, Moveable {
    // ========================================================================
    public Tmb_Vases (Item... items) {
        super(items);

        this.description = "The various clay vases and jars lying around the floor "
                         + "have collected a generous amount of dirt, dust, and cobwebs. "
                         + "They're decorated plainly, as if made by a peasant.";
        this.searchDialog = "There aren't too many vases to search. You peek into "
                          + "them all.";

        this.addNameKeys("(?:clay )?(?:vases?|jars?)");
    }
    // ======================================================================== 
}


