package East_Outer_Wall;

import A_Main.AudioPlayer;
import A_Super.Room;

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
        if (dir == 's')
            return "The balcony railing is that way.";
        else {
            AudioPlayer.playEffect(6);
            return "There is a wall in the way."; 
        }
    }
/*----------------------------------------------------------------------------*/ 
}
