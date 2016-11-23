package West_Balcony;

import Super.Furniture;

public class Wbal_Frst extends Furniture{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Wbal_Frst(String NAME) {
        super(NAME);
        this.searchable = false;
        this.description = "The large expanse of trees extends to the south until\n"
                         + "terminating at the foothills of a distant mountain.\n"
                         + "To the east, it wraps around and leads back to your\n"
                         + "village.";
        this.searchDialog = "It's pretty dark and spooky. You can't event get to\n"
                          + "it from here anyway.";
        this.addNameKeys("forest", "woods", "dark forest");
    }
/*----------------------------------------------------------------------------*/
}
