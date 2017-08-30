package Closet;

import A_Super.Direction;
import A_Super.Staircase;
/**
 * @author Kevin Rapa
 */
public class Gqua_Ladder extends Staircase {
//-----------------------------------------------------------------------------
    public Gqua_Ladder(Direction direction, String dest) {
        super(direction, dest, 16);
        
        this.description = "It's a sturdy wood ladder nailed to the wall. It "
                         + "leads " + DIR + " a small hatch in the " + 
                (direction == Direction.DOWN ? "floor" : "ceiling") + '.';
        
        this.NAMEKEYS.clear();
        this.addNameKeys("(?:sturdy )?(?:wood )?ladder");
    }
//-----------------------------------------------------------------------------
}
