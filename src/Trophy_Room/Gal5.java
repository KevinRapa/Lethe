package Trophy_Room;

import A_Super.Direction;
import A_Super.Room;

public class Gal5 extends Room {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gal5(String name, String ID) {
        super(name, ID);
        this.description= "To your surprise, this chamber is not lavish as you\n" +
                          "expected. It looks quite abandoned. The room is dark\n" +
                          "with a low ceiling, and you can barely see a thing.\n" +
                          "The weak light shining in from the gallery illuminates\n" +
                          "a glass display in front of you. Cobwebs cover\n" +
                          "an unlit chandelier hanging above it. In a corner to the\n"
                        + "west stands a curio cabinet.";
    }
/*----------------------------------------------------------------------------*/
    @Override public String getBarrier(Direction dir) {
        if (dir != Direction.SOUTH)
            return "It's pitch black, and you shouldn't wander in too far.";
        
        return "There's a wall in the way.";
    }
/*----------------------------------------------------------------------------*/
}
