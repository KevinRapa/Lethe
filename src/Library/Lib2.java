package Library;

import A_Main.AudioPlayer;
import A_Super.Direction;
import A_Super.Room;

public class Lib2 extends Room {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Lib2(String name, String ID) {
        super(name, ID);
    }
/*----------------------------------------------------------------------------*/
    @Override public String getBarrier(Direction dir) {
        AudioPlayer.playEffect(6);
        
        return (dir == Direction.WEST || dir == Direction.EAST) ?
            "There's a bookshelf in the way." : WALL_BARRIER;
    }
/*----------------------------------------------------------------------------*/
}
