package Front_Balcony;

import Super.Furniture;

public class Entr_Rf extends Furniture{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Entr_Rf() {
        super();
        this.searchable = false;
        this.description = "The portico is shaded by an elongated mansard roof\n"
                         + "extending from the castle's front wall.";
        this.searchDialog = "If only you were just a little taller...";
        this.interactDialog = "You definitely can't reach that from here.";
        this.addActKeys("grab", "touch", "poke");
        this.addNameKeys("roof", "ceiling");
    }
/*----------------------------------------------------------------------------*/ 
}
