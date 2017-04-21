package Courtyard;

import A_Super.Furniture;
/**
 * @author Kevin Rapa
 */
public class Cou_Steps extends Furniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Cou_Steps() {
        super();

        this.description = "The long set of crumbling steps climb to a front "
                         + "balcony before the castle's great front doors.";
        this.actDialog = "You can't while at the side of the stairs.";
        this.addActKeys(CLIMBPATTERN, "use");
        this.addNameKeys("(?:crumbling )?(?:staircase|steps|stairs)");
    }
//-----------------------------------------------------------------------------
}
