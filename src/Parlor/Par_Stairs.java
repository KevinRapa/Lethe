package Parlor;

import A_Super.Direction;
import A_Super.Staircase;

public class Par_Stairs extends Staircase {
/* CONSTRUCTOR ---------------------------------------------------------------*/     
    public Par_Stairs(Direction direction, String dest) {
        super(direction, dest, 15);
        this.description = "The thin sandstone stairs lead to the balcony above. ";
    }
//-----------------------------------------------------------------------------
    @Override public String getDescription() {
            return (this.DIR == Direction.DOWN) ? 
                    "The thin sandstone stairs lead down to the first floor." 
                    : this.description;
    }
//-----------------------------------------------------------------------------
}
