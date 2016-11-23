package West_Outer_Wall;

import Super.Furniture;

public class Wow1_Tls extends Furniture{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Wow1_Tls(String NAME) {
        super(NAME);
        this.searchable = false;
        this.description = "A collection of jars filled with unknown liquids,\n"
                         + "brushes, and other small hand tools.";
        this.searchDialog = "The tools hide nothing. Maybe search the shelves\n"
                          + "instead?";
        this.interactDialog = "You aren't sure which to use.";
        this.addNameKeys("jars", "tools", "brushes", "liquids");
    }
/*----------------------------------------------------------------------------*/        
}
