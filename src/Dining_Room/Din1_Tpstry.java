package Dining_Room;

import Super.Furniture;

public class Din1_Tpstry extends Furniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Din1_Tpstry() {
        super();
        this.searchable = false;
        this.description = "A large, renaissance-era tapestry. A well-dressed male\n" +
                           "and female sit together on a log in a grove. Between\n" +
                           "them is a chalice. The chalice bears an unexplainable\n" +
                           "blue glow.";
        this.searchDialog = "You peek behind the heavy tapestry\n" +
                            "and find a blank wall.";
        this.addNameKeys("tapestry", "large tapestry");
/*----------------------------------------------------------------------------*/
    }
}

