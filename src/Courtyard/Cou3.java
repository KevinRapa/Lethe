package Courtyard;

import A_Main.AudioPlayer;
import A_Main.GUI;
import A_Main.Player;
import A_Super.Room;
/**
 * First room entered by the player. 
 * Only room from which the inside of the castle may be accessed.
 * @author Kevin Rapa
 */
public class Cou3 extends Room{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Cou3(String name, String ID) {
        super(name, ID);
    }
//-----------------------------------------------------------------------------
    @Override public String triggeredEvent() {
        if (! Player.hasVisited(this.ID)) {
            AudioPlayer.playEffect(7);
            GUI.out("As you walk into the front courtyard, the huge gates "
                + "slowly swing shut behind you.");
        }               
        return NAME;
    }
//-----------------------------------------------------------------------------
}

