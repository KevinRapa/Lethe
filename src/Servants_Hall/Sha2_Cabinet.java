package Servants_Hall;

import static A_Main.Id.CBNT;
import A_Super.Item;
import A_Super.LockedCabinet;

public class Sha2_Cabinet extends LockedCabinet {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Sha2_Cabinet(Item... items) {
        super(CBNT, items);
        
        this.description = "It's a large wooden double-doored cabinet. It looks\n"
                         + "plain and cheap. It must just house tools for the\n"
                         + "servants.";
        this.actDialog = "The tiny metal key fits perfectly. You turn it and the\n"
                            + "cabinet makes a satisfying *click*";
        this.searchDialog = "The cabinet is locked. Maybe one of the servants\n"
                          + "had a key...";

        this.addNameKeys("(?:large )?(?:wood(?:en)? )?(?:double-doored )?cabinet");
    }    
//*----------------------------------------------------------------------------*/
}
