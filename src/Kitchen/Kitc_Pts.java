package Kitchen;

import A_Super.Furniture;
import A_Super.Item;

public class Kitc_Pts extends Furniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/     
    public Kitc_Pts(Item ... items) {
        super(items);
        this.description = "A bunch of old copper pots and pans hang from the\n"
                         + "ceiling";
        this.searchDialog = "You inspect the rack of pots.";
        this.addNameKeys("(?:old )?(?:copper )?(?:pots?|pans?)");
    }
/*----------------------------------------------------------------------------*/
}
