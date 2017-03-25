package Iron_Hall;

import A_Main.AudioPlayer;
import A_Super.Direction;
import A_Super.Room;

public class Iha1 extends Room {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Iha1(String name, String ID) {
        super(name, ID);
    }
/*----------------------------------------------------------------------------*/    
    @Override public String getBarrier(Direction dir) {
        if (dir == Direction.NORTH) {
            AudioPlayer.playEffect(6);
            return "The door is missing!";
        }
        else
            return bumpIntoWall(); 
    }
/*----------------------------------------------------------------------------*/
}
