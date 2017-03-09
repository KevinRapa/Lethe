package Lookout;

import A_Super.Furniture;
import A_Super.Heavy;

public class Look_Cliff extends Furniture implements Heavy {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Look_Cliff() {
        super();

        this.description = "The winding cliff forms the shoreline to the south\n"
                         + "and terminates at the distant lighthouse.";
        this.searchDialog = "The cliff is too far away to do that.";
        this.actDialog = "What are you talking about? The cliff is nearly a mile away!";
        
        this.addActKeys("jump", CLIMBPATTERN);
        this.addNameKeys("(?:winding )?cliff");
    }
/*----------------------------------------------------------------------------*/
}
