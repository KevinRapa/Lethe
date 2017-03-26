package Dining_Room;

import A_Super.Carpet;

public class Din1_Carpet extends Carpet {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Din1_Carpet() {
        super();

        this.description = "The clean lavender carpet lies under the table and "
                         + "chairs, and covers most of the cold stone floor.";
        this.searchDialog = "To your great curiosity, lifting up the carpet "
                          + "reveals a second identical carpet underneath.";
        
        this.addNameKeys("(?:clean )?(?:lavender )?(?:carpet|rug)");
    }
/*----------------------------------------------------------------------------*/
}
