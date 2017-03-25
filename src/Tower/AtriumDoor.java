package Tower;

import A_Super.Direction;
import A_Super.Door;
/**
 * @author Kevin Rapa
 */
public class AtriumDoor extends Door {
    // ========================================================================
    public AtriumDoor (Direction dir) {
        super(dir);
        
        this.description = "The double doors are symmetrical and decorated with\n"
                         + "a fine lattice embossing. A carving of a snake curves\n"
                         + "around the edge of each door.";

        this.addNameKeys("(?:imposing )?(?:black )?(?:iron )?(?:double-?)?doors?");
    }
    // ========================================================================    
}


