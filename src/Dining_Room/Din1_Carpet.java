package Dining_Room;

import A_Super.Furniture;

public class Din1_Carpet extends Furniture{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Din1_Carpet() {
        super();

        this.description = "The clean lavender carpet lies under the table and\n"
                         + "chairs, and covers most of the cold stone floor.";
        this.searchDialog = "To your great curiosity, lifting up the carpet\n"
                          + "reveals a second identical carpet underneath.\n"
                          + "Confused, you leave the carpet alone.";
        this.addNameKeys("(?:clean )?(?:lavender )?(?:carpet|rug)");
    }
/*----------------------------------------------------------------------------*/
}
