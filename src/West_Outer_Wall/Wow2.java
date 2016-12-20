package West_Outer_Wall;

import Main.AudioPlayer;
import Super.Room;

public class Wow2 extends Room{
/* CONSTRUCTOR ---------------------------------------------------------------*/      
    public Wow2(String name, String ID) {
        super(name, ID);
        this.description = "You are on the east side of a large two-story room.\n" +
                           "Right before you is a crumbled down staircase which\n" +
                           "once led to a balcony above you. There's a boarded\n" +
                           "up door on the east wall of this room. To your west,\n" +
                           "plate armor stands against the wall next to a large\n" +
                           "hearth. Through a window to the south, you can see\n" +
                           "out the front of the castle.";
    }  
/*----------------------------------------------------------------------------*/        
    @Override public String getBarrier(char dir) { 
        if (dir == 'd')
            return "The door here is battered and boarded up.";
        else {
            AudioPlayer.playEffect(6);
            return "There is a wall in the way.";
        }
    }
/*----------------------------------------------------------------------------*/
    @Override public String getDescription() {
        String rep = this.description;
        
        if (this.hasFurniture("ladder"))
            rep = "You are on the east side of a large two-story room.\n" +
                   "Right before you is a crumbled down staircase which\n" +
                   "once led to a balcony above you. A ladder now rests against the lip of the balcony. There's a boarded\n" +
                   "up door on the east wall of this room. To your west,\n" +
                   "plate armor stands against the wall next to a large\n" +
                   "hearth. Through a window to the south, you can see\n" +
                   "out the front of the castle.";
        
        return rep;
    }
}
