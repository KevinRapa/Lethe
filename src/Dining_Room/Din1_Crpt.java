package Dining_Room;

import Super.Furniture;

public class Din1_Crpt extends Furniture{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Din1_Crpt(String NAME) {
        super(NAME);
        this.searchable = false;
        this.description = "The clean lavender carpet lies under the table and\n"
                         + "chairs, and covers most of the cold stone floor.";
        this.searchDialog = "To your great curiosity, lifting up the carpet\n"
                          + "reveals a second identical carpet underneath.\n"
                          + "Confused, you leave the carpet alone.";
        this.addNameKeys("carpet", "rug");
    }
/*----------------------------------------------------------------------------*/
}
