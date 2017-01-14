package Prison;

import A_Super.Furniture;
import A_Super.Item;
import A_Super.Openable;
/**
 * @author Kevin Rapa
 */
public class Pris_Cbnt extends Furniture implements Openable {
    // ========================================================================
    public Pris_Cbnt (Item... items) {
        super(items);

        this.description = "It's an old wood cabinet. The doors look ready to\n"
                         + "fall off their hinges.";
        this.searchDialog = "You open the cabinet.";

        this.addNameKeys("(?:old )?(?:wooden )?cabinet");
    }
    // ======================================================================== 
}


