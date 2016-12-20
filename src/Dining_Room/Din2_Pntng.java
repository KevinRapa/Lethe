package Dining_Room;

import Super.Furniture;

public class Din2_Pntng extends Furniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Din2_Pntng() {
        super();
        this.searchable = false;
        this.description = "The wide painting illustrates a view of a long dinner\n" +
                           "table. A single man sits at the center of the table.\n" +
                           "He looks right at you with a serious, almost malevolent\n" +
                           "stare. 'Why would anyone hang this in their house?' You\n" +
                           "ask yourself.";
        this.searchDialog = "There isn't anything unusual about this painting.";
        this.interactDialog = "You lift the painting to find a blank wall.";
        this.addActKeys("move", "lift", "take", "slide", "remove");
        this.addNameKeys("painting", "long painting");
/*----------------------------------------------------------------------------*/
    }
}
