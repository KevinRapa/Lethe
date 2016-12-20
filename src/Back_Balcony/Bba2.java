package Back_Balcony;

import Main.AudioPlayer;
import Super.Room;

public class Bba2 extends Room{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Bba2(String name, String ID) {
        super(name, ID);
        description= "A balcony behind the castle extends to your west. A stone\n" +
                     "railing lining the edge sprouts columns which hold a roof\n" +
                     "over your head. The balcony is bare except for a sconce\n" +
                     "lighting it dimly. Behind you is an intriguing door. Far\n"
                   + "below, there is an immense drop to the sea where waves\n" +
                     "crash against the cliff. The sea extends northwards and to\n" +
                     "the west indefinitely, but to the east, you can see the\n" +
                     "village you left behind a shoreline.\n";
    }
/*----------------------------------------------------------------------------*/
    @Override public String getBarrier(char dir) {
        if (dir == 'w')
            return "There's a couple hundred foot drop right there.";
        else {
            AudioPlayer.playEffect(6);
            return "There is a wall in the way.";
        }
    }
/*----------------------------------------------------------------------------*/
}
