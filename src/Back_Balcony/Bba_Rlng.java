package Back_Balcony;

import Super.Furniture;

public class Bba_Rlng extends Furniture{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Bba_Rlng() {
        super();
        this.searchable = false;
        this.description = "A thick granite railing.";
        this.searchDialog = "This railing hides nothing.";
        this.interactDialog = "You grab the railing, but there's no fear of falling over,\n"
                            + "right?";
        this.addActKeys("grab", "hold");
        this.addNameKeys("stone railing", "railing", "granite railing");
    }
/*----------------------------------------------------------------------------*/
}
