package Rotunda;

import A_Super.Furniture;
import A_Super.Heavy;

public class Rotu_Sky extends Furniture implements Heavy {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Rotu_Sky() {
        super();

        this.description = "You gaze at the dark sky. The stars are bright and\n"
                         + "a bit of moonlight shines in.";
        this.searchDialog = "Don't be silly.";
        this.addNameKeys("(?:dark )?sky");
    }
/*----------------------------------------------------------------------------*/
}