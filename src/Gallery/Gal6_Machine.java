package Gallery;

import A_Super.Furniture;

public class Gal6_Machine extends Furniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gal6_Machine() {
        super();

        this.searchDialog = "Everything on the machine looks attached "
                          + "and not removable.";
        this.description = "The machine is a tall metal box with a bunch of dials, "
                         + "wires, and lights. Some wires feed out the back directly "
                         + "into the wall. Above, an extension resembling a shower "
                         + "head comes out the top of the machine. Oh, what's this? "
                         + "There's a single button on the front. Better not press "
                         + "that...";
        this.actDialog = "Turning the dials does... nothing at all it seems.";
        
        this.addActKeys("turn");
        this.addNameKeys("(?:metal )?machine", "shower head", "dials?|wires?|lights?");
    }
//-----------------------------------------------------------------------------
}

