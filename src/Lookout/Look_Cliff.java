package Lookout;

import A_Super.Furniture;

public class Look_Cliff extends Furniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Look_Cliff() {
        super();

        this.description = "The winding cliff forms the shoreline to the south\n"
                         + "and terminates at the distant lighthouse.";
        this.searchDialog = "The cliff is too far away to do that.";
        this.addNameKeys("(?:winding )?cliff");
    }
/*----------------------------------------------------------------------------*/
}
