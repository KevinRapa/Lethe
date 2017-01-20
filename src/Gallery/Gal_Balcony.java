package Gallery;

import A_Super.Furniture;

public class Gal_Balcony extends Furniture{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gal_Balcony() {
        super();
        this.searchable = false;
        this.description = "The balcony wraps around the perimeter of the central\n"
                         + "chamber.";
        this.addNameKeys("balcony");
    }
/*----------------------------------------------------------------------------*/
}
