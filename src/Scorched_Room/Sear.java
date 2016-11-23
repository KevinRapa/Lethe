package Scorched_Room;

import Super.Room;

public class Sear extends Room{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Sear(String name, String ID) {
        super(name, ID);
        description= "This room is horrific! Everything is burned up and\n" +
                     "the floor is coated in ash and chunks of wood.\n" +
                     "Right beside you, against the door, a skeleton lies. \n" +
                     "They were definitely trying to escape this room. There\n"
                   + "is an interesting fissure in the wall to the north.";
    }
/*----------------------------------------------------------------------------*/
    @Override public String getBarrier(char dir) {
        String rep = "There is a wall in the way.";
        
        if (dir == 'a')
            rep = "The door here is boarded up.";
        if (dir == 'w')
            rep = "You're too stocky to fit through the fissure.";
        
        return rep;
    }
/*----------------------------------------------------------------------------*/
}
