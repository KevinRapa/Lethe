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

