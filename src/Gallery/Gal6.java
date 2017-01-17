package Gallery;

import A_Super.Direction;
import A_Super.Room;

public class Gal6 extends Room{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gal6(String name, String ID) {
        super(name, ID);
        description= "As your head rises above the hatch in the floor, you are\n" +
                     "stunned to see this room filled with technology that you\n" +
                     "have never encountered before. Many futuristic electronics\n" +
                     "are displayed on the floor. In the center of the room,\n" +
                     "a machine resembling an electronic cannon points into the\n" +
                     "central chamber. In a south corner, a bizarre helmet sits\n"
                   + "on a table. On the floor at the north end of the room stands\n"
                   + "a metal machine. On a table against the west wall is some\n"
                   + "kind of unknown apparatus.";
    }
/*----------------------------------------------------------------------------*/
    @Override public String getBarrier(Direction dir) {
        if (dir == Direction.EAST)
            return "There's just open space that way. Wouldn't want to fall.";
        else 
            return bumpIntoWall();
    }
/*----------------------------------------------------------------------------*/
}