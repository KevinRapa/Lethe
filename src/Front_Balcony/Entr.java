package Front_Balcony;

import Super.Room;

public class Entr extends Room {
/* CONSTRUCTOR ---------------------------------------------------------------*/      
    public Entr(String name, String ID) {
        super(name, ID);
        this.description = "You stand before the castle's door atop the steps on\n" +
                           "a long balcony. Three columns on each side hold up a\n" +
                           "roof over the lofty portico.\n" +
                           "Statues also line the balcony on each side in front\n" +
                           "of each side railing.";
    }  
/*----------------------------------------------------------------------------*/        
    @Override public String getBarrier(char dir) {
        String rep = "There's a wall in the way.";
        
        if (dir == 'd' || dir == 'a')
            rep = "There's just a railing that way.";
        
        return rep;
    }
/*----------------------------------------------------------------------------*/
}
