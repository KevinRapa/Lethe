package Tower;

import A_Main.Player;
import A_Super.Direction;
import A_Super.Door;
import A_Super.Item;
/**
 * @author Kevin Rapa
 */
public class Tow2_DrN extends Door {
    // ========================================================================
    public Tow2_DrN (Direction dir) {
        super(dir);
        
        this.description = "The metal double doors are incised with many curved\n"
                         + "decorative etchings. Five circular etchings weave\n"
                         + "themselves in with the numerous etchings in a pentagonal shape.\n"
                         + "A stream of blue light fills ";

        this.addNameKeys("(?:imposing )?(?:glowing )?(?:metal )?(?:double-?)?doors?", "(?:door )?etchings?");
    }
    // ======================================================================== 
    @Override public String getDescription() {
        int numPhylacteries = 0;
        
        for (Item i : Player.getInv())
            if (i.getType().matches("phylactery"))
                numPhylacteries++;
        
        switch (numPhylacteries) {
            case 0:
                return this.description.concat("none of the circular etchings.");
            case 5:
                return this.description.concat("all of the circular etchings.");
            default:
                return this.description.concat(numPhylacteries + " of the circular etchings.");
        }
    }
    // ========================================================================      
}


