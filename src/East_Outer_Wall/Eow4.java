package East_Outer_Wall;

import Super.Room;

public class Eow4 extends Room {
/* CONSTRUCTOR ---------------------------------------------------------------*/      
    public Eow4(String name, String ID) {
        super(name, ID);
        this.description = "You stand atop the east outer wall balcony. This\n" +
                           "balcony is bare, though a door to the west leads\n" +
                           "into a room above the west side of this chamber.";
    }  
/*----------------------------------------------------------------------------*/   
    @Override public String getBarrier(char dir) {
        String rep = "There is a wall in the way.";
        
        if (dir == 's')
            rep = "The balcony railing is that way.";
        
        return rep;
    }
/*----------------------------------------------------------------------------*/ 
}
