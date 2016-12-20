package Dining_Room;

import Super.Furniture;
import Super.Item;
        
public class Din1_Tbl extends Furniture {

/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Din1_Tbl(Item... items) {
        super(items);
        this.description = "The table must be twenty feet long! A scarlet\n"
                         + "tablecloth coats its dark polished surface.";
        this.searchDialog = "You look on the table's surface.";
        this.addNameKeys("table", "long table");
    }
/*----------------------------------------------------------------------------*/
}
