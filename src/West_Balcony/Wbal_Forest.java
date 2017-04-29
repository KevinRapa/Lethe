package West_Balcony;

import A_Super.Furniture;

public class Wbal_Forest extends Furniture{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Wbal_Forest() {
        super();

        this.description = "The large expanse of trees extends to the south until "
                         + "terminating at the foothills of a distant mountain. "
                         + "To the east, it wraps around and leads back to your "
                         + "village.";
        this.searchDialog = "It's pretty dark and spooky. You can't even get to "
                          + "it from here anyway.";
        this.addNameKeys("(?:dark )?(?:forest|woods)");
    }
//-----------------------------------------------------------------------------
}
