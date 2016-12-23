package Library;

import A_Main.AudioPlayer;
import A_Super.Room;

public class Lib5 extends Room{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Lib5(String name, String ID) {
        super(name, ID);
        description= "You walk down the balcony to the south wall. This area has\n" +
                     "only a bookshelf labeled \"Banishment\" and a standing \n" +
                     "candelabra. From here, you can see out over the first-floor\n" +
                     "library.";
    }
/*----------------------------------------------------------------------------*/
    @Override public String getBarrier(char dir) {
        String rep = "There is a wall in the way.";
        
        if (dir == 's') {
            AudioPlayer.playEffect(6);
            rep = "There's a bookshelf in the way.";
        }
        if (dir == 'd')
            rep = "The balcony railing is that way.";
        
        else
            AudioPlayer.playEffect(6);
        
        return rep;
    }
/*----------------------------------------------------------------------------*/
}
