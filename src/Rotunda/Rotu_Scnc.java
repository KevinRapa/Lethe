package Rotunda;

import Super.Furniture;

public class Rotu_Scnc extends Furniture{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Rotu_Scnc() {
        super();
        this.searchable = false;
        this.description = "It's a spherical light. It's so bright! And there\n"
                         + "looks not to be a bulb inside.";
        this.searchDialog = "You're no wizard, but it's glass filled with\n"
                          + "some sort of magical gas or aether.";
        this.interactDialog = "Hmm... You really expected that to hurt, but it is quite cool\n"
                    + "to the touch.";
        this.addNameKeys("sconce", "sconces", "spherical sconces", "spherical sconce");
        this.addActKeys("touch", "grab", "hold");
    }
/*----------------------------------------------------------------------------*/
}

