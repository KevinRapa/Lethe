package Courtyard;

import Super.Room;

public class Cou1 extends Room{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Cou1(String name, String ID) {
        super(name, ID);
        description= "You're in the northwest section of the courtyard,\n" +
                     "on the left side of the tall set of steps. This area\n" +
                     "is completely overgrown with thorns. You can barely\n" +
                     "make out a ruined stone bench hiding beneath it. This\n" +
                     "area is just a nook beside the front steps, and appears\n" +
                     "to lead nowhere.";
    }
/*----------------------------------------------------------------------------*/
    @Override public String getBarrier(char dir) {
        String rep = "There is a wall in the way.";
        if (dir == 'd')
            rep = "You'll need to climb the steps to get up there.";
        if (dir == 'w' || dir == 'a')
            rep = "There's too much thorny growth to go anywhere else.";
        
        return rep;
    }
/*----------------------------------------------------------------------------*/
}
