package Observatory;

import A_Main.AudioPlayer;
import A_Super.Room;

public class Obs2 extends Room{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Obs2(String name, String ID) {
        super(name, ID);
        description= "The second floor is a wide balcony opposite the large\n"
                   + "window to the west. At the north end is a second spiral\n"
                   + "staircase leading to the third floor balcony. A bookshelf\n"
                   + "stands beside a lounge chair to your right against the wall.\n"
                   + "A painting hangs on the wall above the lounge chair, and\n"
                   + "the area is lit by a small lamp resting on an end table.";
    }
/*----------------------------------------------------------------------------*/
    @Override public String getBarrier(char dir) {
        if (dir == 'a')
            return "The balcony railing is that way.";
        
        AudioPlayer.playEffect(6);
        return "There is a wall in the way.";
    }
/*----------------------------------------------------------------------------*/
}
