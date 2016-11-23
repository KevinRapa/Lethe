package Dining_Room;

import Super.Room;

public class Din2 extends Room{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Din2(String name, String ID) {
        super(name, ID);
        description= "You can see over the whole dining room from the balcony.\n"
                   + "Behind you on the west wall hangs a long painting. To the\n"
                   + "south stands the closed door that you heard swing shut.";
    }
/*----------------------------------------------------------------------------*/
    @Override public String getBarrier(char dir) {
        String rep = "There's a wall in the way.";
        if (dir == 'd')
            rep = "There's a railing that way.";
        
        return rep;
    }
/*----------------------------------------------------------------------------*/
}