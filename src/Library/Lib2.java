package Library;

import A_Main.AudioPlayer;
import A_Main.Id;
import A_Main.Player;
import A_Super.Direction;
import A_Super.Room;

public class Lib2 extends Room {
    private final String DESC_MOVED;
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Lib2(String name, String ID) {
        super(name, ID);
        
        DESC_MOVED = this.description.replaceFirst("a bookshelf", "the displaced bookshelf");
    }
/*----------------------------------------------------------------------------*/
    @Override public String getDescription() {
            return Player.getPos().isAdjacent(Id.LIB1) ? 
                    this.DESC_MOVED : 
                    this.description;
    }
/*----------------------------------------------------------------------------*/
    @Override public String getBarrier(Direction dir) {
        AudioPlayer.playEffect(6);
        
        return (dir == Direction.WEST || dir == Direction.EAST) ?
            "There's a bookshelf in the way." : WALL_BARRIER;
    }
/*----------------------------------------------------------------------------*/
}
