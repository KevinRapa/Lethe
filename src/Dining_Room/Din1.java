package Dining_Room;

import A_Main.AudioPlayer;
import A_Main.GUI;
import A_Super.Room;
import A_Main.Player;
/**
 * Superficial, except that one plate needed for the observatory puzzle is here.
 * 
 * @see Dining_Room.Din1_Crvc
 * @see Observatory.Obs_Slts
 * @author Kevin Rapa
 */
public class Din1 extends Room{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Din1(String name, String ID) {
        super(name, ID);
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
    @Override public String triggeredEvent() {
        if (! Player.hasVisited(this.ID)) {
            AudioPlayer.playEffect(8);
            GUI.out("As you enter, you hear a door above you\n"
                  + "swing shut.");
        }    
        return STD_RM_OUT;
    }
/*----------------------------------------------------------------------------*/   
}

