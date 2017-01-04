package Dining_Room;

import A_Super.Direction;
import A_Super.Staircase;

public class Din1_Strs extends Staircase {
/* CONSTRUCTOR ---------------------------------------------------------------*/     
    public Din1_Strs(Direction direction, int height) {
        super(direction, height);
        this.description = "The stone staircase leads straight up to the\n"
                         + "balcony. A lavender carpet runs its surface.";
        this.searchDialog = "In searching the stairs, you find it as clean\n"
                          + "as the rest of this room.";
    }
/*----------------------------------------------------------------------------*/
    @Override public String getDescription() {
        String rep = this.description;
        
        if (this.DIR == Direction.DOWN) {
            rep = "The stone staircase leads straight down to the first floor.\n"
                + "A lavender carpet runs its surface."; 
        }
        return rep;
    }
/*----------------------------------------------------------------------------*/
}
