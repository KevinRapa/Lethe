package Lookout;

import A_Super.Furniture;
import A_Super.Unmoveable;

public class Look_Lighthouse extends Furniture implements Unmoveable {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Look_Lighthouse() {
        super();

        this.description = "A classic red and white striped lighthouse. Its\n"
                         + "beacon illuminates northwards. You wish it would\n"
                         + "maybe spot you.";
        this.searchDialog = "The lighthouse is absolutely too far away to do that.";
        this.actDialog = "You consider yourself a decent swimmer, but that doesn't\n"
                       + "seem very feasible to do.";
        
        this.addActKeys("walk", "swim", "go");
        this.addNameKeys("(?:classic )?(?:red and white )?(?:striped )?lighthouse");
    }
/*----------------------------------------------------------------------------*/
}