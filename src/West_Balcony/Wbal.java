package West_Balcony;

import A_Main.AudioPlayer;
import A_Super.Room;

public class Wbal extends Room{

/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Wbal(String name, String ID) {
        super(name, ID);
        description = "You are on a square balcony at the front left corner of\n" +
                      "the castle. Littered all over the floor are pieces of\n" +
                      "wood. In the center stands a tall beacon of fire. To\n" +
                      "the west, you see the sea following a long cliff and\n" +
                      "a distant lighthouse. To your south, you look upon the\n" +
                      "dark forest you walked through to get here.";
    }
/*----------------------------------------------------------------------------*/
    @Override public String getBarrier(char dir) {
        if (dir == 'a' || dir == 's')
            return "That's a couple hundred foot drop right there.";
        else {
            AudioPlayer.playEffect(6);
            return "There is a wall in the way.";
        }
    }
/*----------------------------------------------------------------------------*/
}
