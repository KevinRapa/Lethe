package Dining_Room;

import A_Super.WallArt;

public class Din2_Painting extends WallArt {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Din2_Painting() {
        super();
        this.description = "The wide painting illustrates a view of a long dinner\n" +
                           "table. A single man sits at the center of the table.\n" +
                           "He looks right at you with a serious, almost malevolent\n" +
                           "stare. 'Why would anyone hang this in their house?' You\n" +
                           "ask yourself.";
        this.addNameKeys("(?:long |wide )?painting");
/*----------------------------------------------------------------------------*/
    }
}
