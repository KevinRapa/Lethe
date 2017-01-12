package Courtyard;

import A_Super.Direction;
import A_Super.Room;
/**
 * The starting and ending point of the game.
 * If the player reaches this room for the second time, the game is completed.
 * 
 * @author Kevin Rapa
 */
public class Cou4 extends Room {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Cou4(String name, String ID) {
        super(name, ID);
        description= "You stand at the foot of the castle's well-fortified front\n" +
                     "gate. Behind you lies the long dark trail through the forest\n" +
                     "you took to get here. Ahead, the monstrous castle looms over\n" +
                     "you and appears most uninviting. Of course, you were invited\n" +
                     "here, correct? You ponder a moment, but you can't quite\n" +
                     "remember.";
    }
/*----------------------------------------------------------------------------*/
    @Override public String getBarrier(Direction dir) {
        if (dir == Direction.SOUTH)
            return "This residence is not what you expected, and you could\n"
                + "turn back now. But still, you are compelled to continue\n"
                + "forward.";
        else 
            return bumpIntoWall();
    }
/*----------------------------------------------------------------------------*/
}