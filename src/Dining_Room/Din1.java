package Dining_Room;

import Core.GUI;
import Super.Room;
import Core.Player;

public class Din1 extends Room{
    private final Player REF;
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Din1(String name, String ID, Player plyr) {
        super(name, ID);
        this.REF = plyr;
        description= "You're in the castle dining hall. The room is illuminated\n"
                   + "solely from the bright moonlight. You stand on its west side\n" +
                     "staring through a row of columns under its second floor\n" +
                     "balcony. You wonder at the room's grandeur. On its east\n" +
                     "end, a massive window spans the wall's width and both\n" +
                     "stories of the room. Twenty chairs sit around a long\n" +
                     "table on a carpet in the room's center below a white gold\n" +
                     "chandelier. On the north wall hangs a large tapestry.\n" +
                     "Below it, a set of stairs climbs against the wall to the\n"
                   + "balcony.";
    }
/*----------------------------------------------------------------------------*/
    @Override public String triggeredEvent(Room[][][] map) {
        if (! REF.hasVisited(this.ID)) {
            GUI.out("As you enter, you hear a door above you\n"
                  + "swing shut.");
        }    
        return "You are " + this + ".";
    }
/*----------------------------------------------------------------------------*/   
}

