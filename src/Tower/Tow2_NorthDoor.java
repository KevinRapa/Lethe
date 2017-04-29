package Tower;

import A_Main.Player;
import A_Super.Direction;
import A_Super.Door;
/**
 * @author Kevin Rapa
 */
public class Tow2_NorthDoor extends Door {
    //-------------------------------------------------------------------------
    public Tow2_NorthDoor (Direction dir) {
        super(dir);
        
        this.description = "The metal double doors are incised with many curved "
                         + "decorative etchings. Five circular etchings arranged pentagonally "
                         + "weave themselves in with the numerous other etchings. "
                         + "A stream of blue light fills ";

        this.addNameKeys("(?:imposing )?(?:glowing )?(?:metal )?(?:double-?)?doors?", "(?:door )?etchings?");
    }
    //------------------------------------------------------------------------- 
    @Override public String getDescription() {
        int numPhyl = Player.getInv().countPhylacteries();
        
        switch (numPhyl) {
            case 0:
                return this.description.concat("none of the circular etchings.");
            case 5:
                return this.description.concat("all of the circular etchings.");
            default:
                return this.description.concat(numPhyl + " of the circular etchings.");
        }
    }
    //-------------------------------------------------------------------------      
}


