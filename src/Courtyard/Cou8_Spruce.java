package Courtyard;

import A_Super.Item;
import A_Super.Direction;
/**
 * @author Kevin Rapa
 */
public class Cou8_Spruce extends Cou5_Spruce {

    // ========================================================================
    public Cou8_Spruce (Item vial, Item extrct, Item ... items) {
        super(vial, extrct, items);
        
        this.dir = Direction.DOWN;
        
        this.actDialog = "You climb back down.";
        
        this.description = 
                "You are sheltered inside the spruce canopy, about "
                + "15 feet above the ground. The only thing of interest "
                + "is a medium-sized raven's nest out on a nearby branch.";
    }
    // ========================================================================   
}


