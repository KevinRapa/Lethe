package Lookout;

import A_Super.Furniture;

public class Look_Clff extends Furniture{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Look_Clff() {
        super();
        this.searchable = false;
        this.description = "The winding cliff forms the shoreline to the south\n"
                         + "and terminates at the distant lighthouse.";
        this.searchDialog = "The cliff is too far away to do that.";
        this.addNameKeys("cliff");
    }
/*----------------------------------------------------------------------------*/
}
