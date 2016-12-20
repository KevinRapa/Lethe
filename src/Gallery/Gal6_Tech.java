package Gallery;

import Super.Furniture;

public class Gal6_Tech extends Furniture{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gal6_Tech() {
        super();
        this.searchable = false;
        this.description = "Wow! So much cool technology! This sure beats coal\n"
                         + "and steam.";
        this.searchDialog = "You can't decide which thing to search first!";
        this.addNameKeys("technology");
    }
/*----------------------------------------------------------------------------*/
}
