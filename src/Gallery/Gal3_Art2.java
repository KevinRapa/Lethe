package Gallery;

import Super.Furniture;

public class Gal3_Art2 extends Furniture {

/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gal3_Art2() {
        super();
        this.searchable = false;
        this.description = "In the corner of the room stands this odd statue.\n"
                         + "It remembles a human, but barely. All you can make\n"
                         + "out are two shoulders and a deformed face with no\n"
                         + "features apart from a couple ears.";
        this.addNameKeys("statue", "deformed statue");
/*----------------------------------------------------------------------------*/
    }
}
