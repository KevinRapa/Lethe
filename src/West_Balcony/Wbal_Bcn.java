package West_Balcony;

import A_Super.Furniture;

public class Wbal_Bcn extends Furniture{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Wbal_Bcn() {
        super();
        this.searchable = false;
        this.description = "It's a ten foot high stone obelisk. At the top is\n"
                         + "a large bowl of flame. It's so bright, I'm sure one\n"
                         + "could see this from a long distance.";
        this.searchDialog = "The beacon is too tall. Plus, it's on fire.";
        this.addNameKeys("beacon");
    }
/*----------------------------------------------------------------------------*/
}
