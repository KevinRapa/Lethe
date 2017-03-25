package Library;

import A_Main.AudioPlayer;
import A_Super.Direction;
import A_Super.Room;

public class Lib5 extends Room{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Lib5(String name, String ID) {
        super(name, ID);
    }
/*----------------------------------------------------------------------------*/
    @Override public String getBarrier(Direction dir) {
       switch (dir) {
            case SOUTH:
                AudioPlayer.playEffect(6);
                return "There's a bookshelf in the way.";
            case EAST:
                return "The balcony railing is that way.";
            default:
                return bumpIntoWall();
        }
    }
/*----------------------------------------------------------------------------*/
}
