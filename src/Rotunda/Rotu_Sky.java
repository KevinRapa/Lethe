package Rotunda;

import A_Super.Furniture;
import A_Super.Unmoveable;

public class Rotu_Sky extends Furniture implements Unmoveable {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Rotu_Sky() {
        super();

        this.description = "You gaze at the dark sky. The stars are bright and "
                         + "a bit of moonlight shines in.";
        this.searchDialog = "Don't be silly.";
        this.addNameKeys("(?:dark )?sky");
    }
//-----------------------------------------------------------------------------
}