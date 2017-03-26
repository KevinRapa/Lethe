package Prison;

import A_Super.Item;
import A_Super.Moveable;
import A_Super.Openable;
import A_Super.SearchableFurniture;
/**
 * @author Kevin Rapa
 */
public class Pris_Cabinet extends SearchableFurniture implements Openable, Moveable {
    // ========================================================================
    public Pris_Cabinet (Item... items) {
        super(items);

        this.description = "It's an old wood cabinet. The doors look ready to "
                         + "fall off their hinges.";
        this.searchDialog = "You open up the cabinet.";

        this.addNameKeys("(?:old )?(?:wooden )?cabinet");
    }
    // ======================================================================== 
}


