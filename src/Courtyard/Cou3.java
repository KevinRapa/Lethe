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
        description= "You're in the center of an overgrown courtyard, just in\n" +
                     "front of the main gate. You are surrounded on all sides\n" +
                     "by the fortress-like castle wall. Before you climbs a\n" +
                     "great set of crumbling steps to the castle's entrance.\n" +
                     "The courtyard forks to your left and right, wrapping\n" +
                     "around to the sides of the steps. Ivy grows rampantly\n" +
                     "on and over everything. To your left and right appears\n" +
                     "as what used to be a couple fountains.";
    }
/*----------------------------------------------------------------------------*/
    @Override public String triggeredEvent() {
        Room cou4 = Player.getRoomRef("COU4");

        if (! cou4.isThisLocked()) {
            cou4.lock();
            AudioPlayer.playEffect(7);
            GUI.out("As you walk into the front courtyard, the huge gates\n"
                + "slowly swing shut behind you.");
        }               
        return "You are " + this + ".";
    }
/*----------------------------------------------------------------------------*/
}

