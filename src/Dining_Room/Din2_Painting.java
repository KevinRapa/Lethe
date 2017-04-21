package Dining_Room;

import A_Super.WallArt;

public class Din2_Painting extends WallArt {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Din2_Painting() {
        super();
        this.description = "The wide painting illustrates a view of a long dinner " +
                           "table. A single man sits at the center of the table. " +
                           "He looks right at you with a serious, almost malevolent " +
                           "stare. 'Why would anyone hang this in their house?' You " +
                           "ask yourself.";
        this.addNameKeys("(?:long |wide )?painting");
//-----------------------------------------------------------------------------
    }
}
