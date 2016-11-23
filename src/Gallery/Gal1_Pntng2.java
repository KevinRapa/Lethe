package Gallery;

import Super.Furniture;

public class Gal1_Pntng2 extends Furniture {

/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gal1_Pntng2(String NAME) {
        super(NAME);
        this.searchable = false;
        this.description = "This one is painted in all blue and outlined in white.\n"
                         + "A furious godly figure stands in the middle and appears\n"
                         + "to be burning. The rest of this painting illustrates the\n"
                         + "elements water and fire decoratively.";
        this.searchDialog = "There isn't anything unusual about this painting.";
        this.interactDialog = "You lift the painting to find a blank wall.";
        this.addActKeys("move", "take", "lift", "slide", "remove");
        this.addNameKeys("tibetan painting");
/*----------------------------------------------------------------------------*/
    }
}
