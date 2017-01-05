package Drawing_Room;

import A_Main.GUI;
import A_Super.Room;
import A_Main.Player;

public class Drar extends Room {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Drar(String name, String ID) {
        super(name, ID);
        description= "The moment you enter the room, the first thing you notice\n" +
                     "is a ghostly white apparition sitting on the opposite end.\n" +
                     "It turns toward you, but there is no face you can recognize\n" +
                     "on it. The apparition sits at a bar on the south end of the\n" +
                     "room. There's a billiard table and chess table near a window\n" +
                     "on the east wall. A couch and low table sit on the west side.\n" +
                     "Next to you is a large black piano. This room is unlit save\n" +
                     "the bright moonlight shining in.";
    }
/*----------------------------------------------------------------------------*/
    @Override public String triggeredEvent() {   
        if (! Player.hasVisited(this.ID)) 
            GUI.out("From across the room, an apparition stares at you with\n"
                   + "open eyes.");
          
        return "You are " + this + ".";
    }
/*----------------------------------------------------------------------------*/   
}
