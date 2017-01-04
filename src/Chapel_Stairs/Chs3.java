package Chapel_Stairs;

import A_Main.AudioPlayer;
import A_Super.Direction;
import A_Super.Room;

public class Chs3 extends Room {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Chs3(String name, String ID) {
        super(name, ID);
        description= "You stand a few stories up on the tower's top floor. A door\n"
                   + "stands solemnly in the south wall. The room is otherwise\n"
                   + "unfurnished and carries the notion of purity.";
    }
/*----------------------------------------------------------------------------*/
    @Override public String getBarrier(Direction dir) {
        
        if (dir == Direction.WEST)
            return "The landing's railing protects you from tumbling three stories.";
        else {
            AudioPlayer.playEffect(6);
            return "There is a wall in the way.";
        }
    }
/*----------------------------------------------------------------------------*/
}