package Observatory;

import A_Super.Direction;
import A_Super.Staircase;

public class Obs13_Stairs extends Staircase {
/* CONSTRUCTOR ---------------------------------------------------------------*/     
    public Obs13_Stairs (Direction direction, String dest) {
        super(direction, dest, 14);
        this.description = "The spiral staircase sits in a round alcove carved "
                         + "into the wall to the southeast and leads up to a long, "
                         + "wide balcony on the second floor.";
        this.addNameKeys("spiral stair(?:s|case)");
    }
//-----------------------------------------------------------------------------
    @Override public String getDescription() {
        if (this.DIR == Direction.DOWN) {
            return "The straight set of wood steps lack supports and extend "
                    + "from the north wall. They lead down to the low-eastern "
                    + "balcony.";
        }
        return this.description;
    }
//-----------------------------------------------------------------------------
}

