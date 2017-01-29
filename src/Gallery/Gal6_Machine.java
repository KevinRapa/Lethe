package Gallery;

import A_Super.Furniture;

public class Gal6_Machine extends Furniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gal6_Machine() {
        super();

        this.searchDialog = "Everything on the machine looks concretely attached\n"
                          + "to the machine and not removable.";
        this.description = "The machine is a tall metal box with a bunch of dials,\n"
                         + "wires, and lights. Some wires feed out the back directly\n"
                         + "into the wall. Above, an extension resembling a shower\n"
                         + "head comes out the top of the machine. Oh, what's this?\n"
                         + "There's a single button on the front. Better not press\n"
                         + "that...";
        
        this.addNameKeys("(?:metal )?machine", "shower head");
    }
/*----------------------------------------------------------------------------*/
}

