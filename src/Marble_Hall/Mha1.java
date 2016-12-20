package Marble_Hall;

import Main.GUI;
import Super.Room;
import Main.Player;

public class Mha1 extends Room{
    private final Player REF;
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Mha1(String name, String ID, Player plyr) {
        super(name, ID);
        this.REF = plyr;
        description= "The two-story hallway is clean with a white granite wall\n" +
                     "and a green marble tiled floor. You stand at the north end\n" +
                     "facing south with a door at your left and a window at your\n" +
                     "right. A silver chandelier hangs above you. Next to the\n" +
                     "door is a small potted plant and chair. The door to your left\n"
                   + "bears a large, detailed carving of a cross.";
    }
/*----------------------------------------------------------------------------*/
    @Override public String triggeredEvent(Room[][][] map) {
        String dialog = "You are " + this + ".";
        
        if (! REF.hasVisited(this.ID)) {
            GUI.out("\nAs soon as you enter, you catch a glimpse of a white\n"
                    + "figure passing through a door in the middle of the\n"
                    + "hallway.");
        }    
        return dialog;
    }
/*----------------------------------------------------------------------------*/  
}
