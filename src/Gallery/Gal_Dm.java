package Gallery;

import Super.Furniture;

public class Gal_Dm extends Furniture {

/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gal_Dm() {
        super();
        this.searchable = false;
        this.description = "The glass dome offers a nice view of the stars.";
        this.searchDialog = "Don't be silly.";
        this.addNameKeys("dome", "glass dome");
/*----------------------------------------------------------------------------*/
    }
}
