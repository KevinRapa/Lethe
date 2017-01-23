package Dining_Room;

import A_Super.Item;
import A_Super.SearchableFurniture;
        
public class Din1_Table extends SearchableFurniture {

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
