package Dining_Room;

import A_Super.Furniture;
import A_Super.Item;
        
public class Din1_Table extends Furniture {

/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Din1_Table(Item... items) {
        super(items);
        this.description = "The table must be twenty feet long! A scarlet\n"
                         + "tablecloth coats its dark polished surface.";
        this.searchDialog = "You look on the table's surface.";
        this.addNameKeys("table", "long table");
    }
/*----------------------------------------------------------------------------*/
}
