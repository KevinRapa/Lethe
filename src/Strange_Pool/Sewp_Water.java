package Strange_Pool;

import A_Super.Furniture;
/**
 * @author Kevin Rapa
 */
public class Sewp_Water extends Furniture {
    // ========================================================================
    public Sewp_Water () {
        super();

        this.description = "The water circles rapidly around the pool turning\n"
                         + "the wheel in the center. The driveshaft must be powering\n"
                         + "something. The water drains down a hole at the pool's bottom.";
        this.actDialog = "It's probably not a good idea to step near that pool.";
        this.searchDialog = "Anything that fell in there is long gone at this point.";

        this.addNameKeys("(?:large )?pool", "(?:vortex of )?water", "driveshaft", 
                "(?:submerged )?(?:water )?wheel");
        this.addActKeys("swim", "drink", "jump");
    }
    // ========================================================================      
}


