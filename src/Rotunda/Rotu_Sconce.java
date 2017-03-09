package Rotunda;

import A_Super.Furniture;

public class Rotu_Sconce extends Furniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Rotu_Sconce() {
        super();

        this.description = "It's a spherical light. It's so bright! And there\n"
                         + "looks not to be a bulb inside.";
        this.searchDialog = "You're no wizard, but it's glass filled with\n"
                          + "some sort of magical gas or aether.";
        this.actDialog = "Hmm... You really expected that to hurt, but it is quite cool\n"
                       + "to the touch. The gas is encapsulated, and you cannot obtain any.";
        this.addNameKeys("(?:spherical )?(?:sconces?|lights?)", "(?:magical )?(?:gas|aether)");
        this.addActKeys(GETPATTERN, HOLDPATTERN);
    }
/*----------------------------------------------------------------------------*/
}

