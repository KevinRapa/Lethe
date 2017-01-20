package Dining_Room;

import A_Super.Direction;
import A_Super.Staircase;

public class Din1_Stairs extends Staircase {
/* CONSTRUCTOR ---------------------------------------------------------------*/     
    public Din1_Stairs(Direction direction) {
        super(direction);
        this.description = "The stone staircase leads straight up to the\n"
                         + "balcony. A lavender carpet runs its surface.";
        this.searchDialog = "In searching the stairs, you find it as clean\n"
                          + "as the rest of this room.";
    }
/*----------------------------------------------------------------------------*/
    @Override public String getDescription() {
        if (this.DIR == Direction.DOWN)
            return "The stone staircase leads straight down to the first floor.\n"
                 + "A lavender carpet runs its surface."; 
        
        return this.description;
    }
/*----------------------------------------------------------------------------*/
}
