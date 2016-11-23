package Library;

import Super.Room;

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
        
        if (dir == 's')
            rep = "There's a bookshelf in the way.";
        if (dir == 'd')
            rep = "The balcony railing is that way.";
        
        return rep;
    }
/*----------------------------------------------------------------------------*/
}
