package Dining_Room;

import Super.Furniture;
import Super.Item;

public class Din1_Tpstry extends Furniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Din1_Tpstry(Item ... items) {
        super(items);
        this.description = "A large, renaissance-era tapestry. A well-dressed male\n" +
                           "and female sit together on a log in a grove. Between\n" +
                           "them is a chalice. The chalice bears an unexplainable\n" +
                           "blue glow.";
        this.searchDialog = "Lifting the tapestry, you discover an indentation in the\n"
                          + "wall behind it.";
        this.addNameKeys("tapestry", "large tapestry");
/*----------------------------------------------------------------------------*/
    }
}

