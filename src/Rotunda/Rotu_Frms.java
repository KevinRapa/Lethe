package Rotunda;

import A_Super.Furniture;

public class Rotu_Frms extends Furniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Rotu_Frms() {
        super();
        this.searchable = false;
        this.description = "They are arched, door-shaped, and seem as if they\n"
                         + "form some kind of magical passage.";
        this.searchDialog = "These frames seem as though they hide something, but\n"
                          + "after inspecting every inch, you can only confirm\n"
                          + "they are plain carvings.";
        this.addNameKeys("frame", "frames", "arched frames", "arched frame");
    }
/*----------------------------------------------------------------------------*/
}