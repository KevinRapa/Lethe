package Gallery;

import A_Super.Direction;
import A_Super.Staircase;

public class Gal2_Staircase extends Staircase {
//-----------------------------------------------------------------------------    
    public Gal2_Staircase(Direction direction, String dest) {
        super(direction, dest, 14);
        this.description = "The dark wooden stairs curve following the edge of "
                         + "the balcony until meeting it on the second floor.";
    }
//-----------------------------------------------------------------------------
}