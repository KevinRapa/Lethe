package Tower;

import A_Super.Direction;
import A_Super.Door;
/**
 * @author Kevin Rapa
 */
public class Blck_Strcs_Dr extends Door {
    // ========================================================================
    public Blck_Strcs_Dr (Direction dir) {
        super(dir);
        
        this.description = "The double doors are symmetrical and decorated with\n"
                         + "a fine lattice embossment. A carving of a snake curves\n"
                         + "around the edge of each door.";

        this.addNameKeys("(?:imposing )?(?:black )?(?:iron )?(?:double-?)?doors?");
    }
    // ========================================================================    
}


