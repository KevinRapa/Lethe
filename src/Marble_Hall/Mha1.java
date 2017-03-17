package Marble_Hall;

import A_Main.GUI;
import A_Super.Room;
import A_Main.Player;
/**
 * Connects to Mha2 and Gal2
 * 
 * @see Gallery.Gal2
 * @see Marble_Hall.Mha2
 * @author Kevin Rapa
 */
public class Mha1 extends Room{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Mha1(String name, String ID) {
        super(name, ID);
        description= 
                "The two-story hallway is clean with a white granite wall\n" +
                 "and a green marble tiled floor. You stand at the north end\n" +
                 "facing south. To your east is a white door with a cross on it. On the west wall is a tall window.\n" +
                 "A silver chandelier hangs above you. Next to the\n" +
                 "door is a small potted plant and chair. The door to your left\n"
               + "bears a large, detailed carving of a cross.";
    }
/*----------------------------------------------------------------------------*/
    @Override public String triggeredEvent() {
        if (! Player.hasVisited(this.ID)) {
            GUI.out("As soon as you enter, you catch a glimpse of a white\n"
                  + "figure passing through a door in the middle of the\n"
                  + "hallway.");
        }    
        return STD_RM_OUT;
    }
/*----------------------------------------------------------------------------*/  
}
