package Black_Staircase;

import A_Super.Direction;
import A_Super.Staircase;
/**
 * @author Kevin Rapa
 */
public class Bls_Strcs extends Staircase {
    // ========================================================================
    public Bls_Strcs (Direction dir) {
        super(dir);
        
        this.description = "The long curved staircase wraps around in a half circle\n"
                         + "and connects the atrium floor to its second story balcony.\n"
                         + "It is suspended from the ceiling by many black metal cables.";

        this.addNameKeys("(?:long )?(?:curved )?(?:suspended )?(?:black )?(?:iron )?(?:stair(?:s|case)|steps)");
    }
    // ======================================================================== 
}


