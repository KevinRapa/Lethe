package Tomb;

import A_Super.Furniture;
import A_Super.Item;
import A_Super.Openable;
/**
 * @author Kevin Rapa
 */
public class Tmb_Vs extends Furniture implements Openable {
    // ========================================================================
    public Tmb_Vs (Item... items) {
        super(items);

        this.description = "The various clay vases and jars lying around the floor\n"
                         + "have collected a generous amount of dirt, dust, and cobwebs.\n"
                         + "They're decorated plainly, as if made by a peasant.";
        this.searchDialog = "There aren't too many vases to search. You peek into\n"
                          + "them all.";

        this.addNameKeys("(?:clay )?(?:vases?|jars?)");
    }
    // ======================================================================== 
}


