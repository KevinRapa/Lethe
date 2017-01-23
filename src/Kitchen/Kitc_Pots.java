package Kitchen;

import A_Super.Item;
import A_Super.SearchableFurniture;

public class Kitc_Pots extends SearchableFurniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/     
    public Kitc_Pots(Item ... items) {
        super(items);
        this.description = "A bunch of old copper pots and pans hang from the\n"
                         + "ceiling";
        this.searchDialog = "You inspect the rack of pots.";
        this.addNameKeys("(?:old )?(?:copper )?(?:pots?|pans?)");
    }
/*----------------------------------------------------------------------------*/
}
