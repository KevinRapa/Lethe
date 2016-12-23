package Gallery;

import A_Main.AudioPlayer;
import A_Super.Room;

public class Gal_3W extends Room{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gal_3W(String name, String ID) {
        super(name, ID);
        description= "As your head rises above the hatch in the floor, you are\n" +
                     "stunned to see this room filled with technology that you\n" +
                     "have never encountered before. Many futuristic electronics\n" +
                     "are displayed on the floor. In the center of the room,\n" +
                     "a machine resembling an electronic cannon points into the\n" +
                     "central chamber. In a south corner, a bizarre helmet sits\n"
                   + "on a table. On the floor at the north end of the room stands\n"
                   + "a metal machine. On a table against the west wall is some\n"
                   + "kind of unknown apparatus.";
    }
/*----------------------------------------------------------------------------*/
    @Override public String getBarrier(char dir) {
        if (dir == 'd')
            return "There's just open space that way. Wouldn't want to fall.";
        else {
            AudioPlayer.playEffect(6);
            return "There is a wall in the way.";
        }
    }
/*----------------------------------------------------------------------------*/
}