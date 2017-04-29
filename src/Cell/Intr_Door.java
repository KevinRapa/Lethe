package Cell;

import static A_Main.Names.METAL_BAR;
import A_Super.Direction;
import A_Super.Item;
import Tunnels.Sew_Door;
/**
 * @author Kevin Rapa
 */
public class Intr_Door extends Sew_Door {
    //-------------------------------------------------------------------------
    public Intr_Door () {
        super(Direction.EAST);
        
        this.description = "The metal door offers a view to the outside through "
                         + "a small barred opening. You can "
                         + "see into a larger room with a pool in the center. A vortex "
                         + "of water in the pool spins a water wheel attached to a "
                         + "driveshaft going into the ceiling. You can see a door "
                         + "on the far opposite side and a small black grate in the "
                         + "room's corner. You can't locate the source of the discomforting "
                         + "noise though.";

        this.addActKeys("pry");
        this.addNameKeys("(?:small )?window", "(?:metal )?bars?");
    }
    //-------------------------------------------------------------------------
    @Override public String interact(String key) {
        return (key.equals("pry")) ? 
                "The bars are too thick to pry." : super.interact(key);
    }
    //-------------------------------------------------------------------------
    @Override public String useEvent(Item item) {
        if (item.toString().equals(METAL_BAR)) 
            return "The bars are too thick to pry. Fitting yourself through the "
                    + "opening seems far-fetched as well.";
        else
            return super.useEvent(item);
        
    }
    //-------------------------------------------------------------------------  
}


