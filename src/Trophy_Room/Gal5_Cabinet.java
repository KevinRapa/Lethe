package Trophy_Room;

import static A_Main.Id.GCBT;
import A_Super.Item;
import A_Super.LockedContainer;

public class Gal5_Cabinet extends LockedContainer {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gal5_Cabinet(Item... items) {
        super(GCBT, items);

        this.actDialog = "The tiny gold key fits perfectly. You turn it and the "
                            + "cabinet makes a satisfying *click*.";
        this.description = "It's a large wooden double-door cabinet. It is fancily "
                         + "carved and looks as though it holds something valuable.";
        this.searchDialog = "The cabinet is locked. Looks like you'll need a key.";

        this.addNameKeys("(?:large )?(?:wood(?:en)? )?(?:double-door )?(?:curio )?cabinet");
    }    
//*----------------------------------------------------------------------------*/
}

