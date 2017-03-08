package Trophy_Room;

import A_Main.Id;
import A_Super.Item;
import A_Super.LockedCabinet;

public class Gal5_Cabinet extends LockedCabinet {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gal5_Cabinet(Item... items) {
        super(Id.GCBT, items);

        this.actDialog = "The tiny gold key fits perfectly. You turn it and the\n"
                            + "cabinet makes a satisfying *click*.";
        this.description = "It's a large wooden double-doored cabinet. It is fancily\n"
                         + "carved and looks as though it holds something valuable.";
        this.searchDialog = "The cabinet is locked. Looks like you'll need a key.";

        this.addNameKeys("(?:large )?(?:wood(?:en)? )?(?:double-doored )?(?:curio )?cabinet");
    }    
//*----------------------------------------------------------------------------*/
}

