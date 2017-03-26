package Strange_Pool;

import A_Super.Item;
import East_Outer_Wall.Water;
/**
 * @author Kevin Rapa
 */
public class Sewp_Water extends Water {
    // ========================================================================
    public Sewp_Water (Item bckt) {
        super(bckt);

        this.description = "The water circles rapidly around the pool turning "
                         + "the wheel in the center. The driveshaft must be powering "
                         + "something. The water drains down a hole at the pool's bottom.";
        this.actDialog = "It's probably not a good idea to step near that pool.";
        this.searchDialog = "Anything that fell in there is long gone at this point.";

        this.addNameKeys("(?:large )?pool", "(?:vortex of )?water", "driveshaft", 
                "(?:submerged )?(?:water )?wheel");
    }
    // ========================================================================      
}


