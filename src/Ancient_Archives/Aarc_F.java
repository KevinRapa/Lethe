package Ancient_Archives;

import A_Super.Item;
/**
 * @author Kevin Rapa
 */
public class Aarc_F extends Aarc_Furniture {
    // ========================================================================
    public Aarc_F (Item... items) {
        super(items);
        
        this.description = "The floor is heavily damaged from the sinking of\n"
                         + "earth under the foundation. The floor bends and sinks\n"
                         + "in many places, and much of the furniture here has\n"
                         + "toppled over as a result. You stand on the only intact\n"
                         + "portion of the floor near the west door.";
        this.searchDialog = "You pick through the remains on the ground.";

        this.addNameKeys("floor", "ground", "sinkhole", "soil", 
                "(?:slightly raised )?(?:stone )?platform");
    }
    // ======================================================================== 
}


