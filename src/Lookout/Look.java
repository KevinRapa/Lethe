package Lookout;

import A_Main.AudioPlayer;
import A_Super.Direction;
import A_Super.Room;

public class Look extends Room{

/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Look(String name, String ID) {
        super(name, ID);
        description = "You stand on a square balcony tucked into the side of the\n" +
                      "castle. The balcony is bare except for a valve on the\n" +
                      "wall behind you and a railing at the other end. Far below,\n" +
                      "the sea extends westward alongside a cliff to the south\n" +
                      "of the castle. In the far distance, you spot a lighthouse.";
    }
/*----------------------------------------------------------------------------*/
    @Override public String getBarrier(Direction dir) {
        if (dir == Direction.WEST)
            return "There's a couple hundred foot drop right there.";
        else {
            AudioPlayer.playEffect(6);
            return "There is a wall in the way.";
        }
    }
/*----------------------------------------------------------------------------*/
}
