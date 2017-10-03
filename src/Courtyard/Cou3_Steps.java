package Courtyard;

import A_Super.Staircase;
import A_Super.Direction;
/**
 * @author Kevin Rapa
 */
public class Cou3_Steps extends Staircase {
//-----------------------------------------------------------------------------    
    public Cou3_Steps(Direction direction, String dest) {
        super(direction, dest, 15);
        this.description = "The long set of crumbling steps climb to a front "
                         + "balcony before the castle's great front doors.";
        this.addNameKeys("front (?:steps|stairs)");
    }
//-----------------------------------------------------------------------------
}
