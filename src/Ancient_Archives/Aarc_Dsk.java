package Ancient_Archives;

import A_Super.Item;
/**
 * @author Kevin Rapa
 */
public class Aarc_Dsk extends Aarc_Furniture {
// ========================================================================
    public Aarc_Dsk (Item... items) {
        super(items);

        this.description = "One of the objects in the wood rubble resembles\n"
                         + "an old desk. Though seeming once pristine and\n"
                         + "of luxury quality, the desk now lies crooked\n"
                         + "with two legs missing.";
        this.searchDialog = "You look inside the old desk.";

        this.addNameKeys("(?:old )?(?:wooden )?(?:drawered )?desk", "drawers?");
    }
    // ========================================================================   
}


