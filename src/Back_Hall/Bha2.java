package Back_Hall;

import Super.Room;
import Main.Player;
import Main.GUI;

public class Bha2 extends Room {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Bha2(String name, String ID) {
        super(name, ID);
        description= "You stand at some unknown length in the hallway. It must have been\n"
                   + "maybe fifty paces you took. The floor and walls have degenerated\n"
                   + "and the room has darkened to a deep red hue. There's nothing\n"
                   + "except for some broken pieces of wood and a burnt\n"
                   + "picture frame lying on the floor.";
    }
/*----------------------------------------------------------------------------*/
    @Override public String triggeredEvent() {
        if (! Player.getShoes().matches("shrouded shoes")) {
            if (Player.getLastVisited().matches("BHA1"))
                Player.setOccupies(3,1,2);
            else
                Player.setOccupies(3,1,4);
            
            GUI.out("You start pacing down the hallway in a state of vertigo.\n"
                  + "The hallway paradoxically continues to extend onward and warp\n"
                  + "downwards past a nearby horizon. After a short while, you stop and look behind you,\n"
                  + "seeing the door you just entered still only several feet away.");
        }
        else
            GUI.out("You pace lightly down the hallway almost effortlessly. You\n"
                  + "break free from your state of vertigo. Before long,\n"
                  + "you feel as though you have reached the room's center.");
        
        return "You are " + Player.getOcc() + ".";  
    }
/*----------------------------------------------------------------------------*/
}
