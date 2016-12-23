package Courtyard;

import A_Main.AudioPlayer;
import A_Super.Room;

public class Cou2 extends Room{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Cou2(String name, String ID) {
        super(name, ID);
        description= "You're in the southwest section of the courtyard.\n" +
                     "What barely resembles a fountain forms the centerpiece\n" +
                     "of this area. Barely visible at your feet is a tiled\n" +
                     "walkway surrounding the fountain. Unkept bushes line\n" +
                     "the castle walls to the south and west.";
    }
/*----------------------------------------------------------------------------*/    
    @Override public String getBarrier(char dir) {
        AudioPlayer.playEffect(6);
        
        if (dir == 's')
            return "There is a wall in the way. Though about 15 feet up, you can\n"
                 + "see a fissure in the wall of the castle.";
        else
            return "There is a wall in the way.";
        
    }
/*----------------------------------------------------------------------------*/
}
