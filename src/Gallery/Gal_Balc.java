package Gallery;

import Super.Furniture;

public class Gal_Balc extends Furniture{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gal_Balc(String NAME) {
        super(NAME);
        this.searchable = false;
        this.description = "The balcony wraps around the perimeter of the central\n"
                         + "chamber.";
        this.addNameKeys("balcony");
    }
/*----------------------------------------------------------------------------*/
}
