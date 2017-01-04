package Rotunda;

import A_Super.Furniture;

public class Rotu_Sky extends Furniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Rotu_Sky() {
        super();
        this.searchable = false;
        this.description = "You gaze at the dark sky. The stars are bright and\n"
                         + "a bit of moonlight shines in.";
        this.searchDialog = "Don't be silly.";
        this.addNameKeys("(?:dark )?sky");
    }
/*----------------------------------------------------------------------------*/
}