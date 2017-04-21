package Lookout;

import A_Super.Furniture;
import A_Super.Unmoveable;

public class Look_Cliff extends Furniture implements Unmoveable {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Look_Cliff() {
        super();

        this.description = "The winding cliff forms the shoreline to the south "
                         + "and terminates at the distant lighthouse.";
        this.searchDialog = "The cliff is too far away to do that.";
        this.actDialog = "What are you talking about? The cliff is nearly a mile away!";
        
        this.addActKeys("jump", CLIMBPATTERN);
        this.addNameKeys("(?:winding )?cliff");
    }
//-----------------------------------------------------------------------------
}
