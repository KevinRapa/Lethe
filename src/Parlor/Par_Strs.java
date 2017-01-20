package Parlor;

import A_Super.Direction;
import A_Super.Staircase;

public class Par_Strs extends Staircase {
/* CONSTRUCTOR ---------------------------------------------------------------*/     
    public Par_Strs (Direction direction) {
        super(direction);
        this.description = "The thin sandstone stairs lead to the balcony above.\n";
    }
/*----------------------------------------------------------------------------*/
    @Override public String getDescription() {
        if (this.DIR == Direction.DOWN) {
            return "The thin sandstone stairs lead down to the first floor.";
        }
        
        return this.description;
    }
/*----------------------------------------------------------------------------*/
}
