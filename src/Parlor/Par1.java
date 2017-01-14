package Parlor;

import A_Main.Id;
import A_Super.Direction;
import A_Super.Room;

public class Par1 extends Room{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Par1(String name, String ID) {
        super(name, ID);
        description= "A large fireplace on the south wall lights the lower parlor, but\n"
                   + "gives off no heat. The above balcony extends over the north wall\n"
                   + "into the parlor on several pillars. Below it, a few lounge\n"
                   + "chairs sit around a curious glass orb. At\n"
                   + "the north west corner is a door, but something about it appears off. In the\n"
                   + "open area of the parlor sit a harp and cushion on a persian rug.\n"
                   + "Standing at the east is a wood shelf. At the west side stands a table\n"
                   + "bearing numerous strange etched runes and letters.";
    }
/*----------------------------------------------------------------------------*/ 
    @Override public String getDescription() {
        if (! this.isAdjacent(Id.BHA3))
            return this.description;
        else
            return this.description.replaceFirst("door,\\w+\\.", ".");
    }
/*----------------------------------------------------------------------------*/ 
    @Override public String getBarrier(Direction dir) {
        if (dir == Direction.NORTH && ! this.isAdjacent(Id.BHA3))
            return "The door here feels ice cold and the doorknob won't turn\n"
                 + "despite your strength.";
        else 
            return bumpIntoWall();
    }
/*----------------------------------------------------------------------------*/ 
}
