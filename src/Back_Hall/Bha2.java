package Back_Hall;

import Super.Room;
import Main.Player;
import Main.GUI;

public class Bha2 extends Room {
    private final Player REF;
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Bha2(String name, String ID, Player plyr) {
        super(name, ID);
        description= "You stand at some unknown length in the hallway. It must have been\n"
                   + "maybe fifty paces you took. The floor and walls have degenerated\n"
                   + "and you feel as though you have left the castle. There's nothing\n"
                   + "here except for some broken pieces of wood here and there. A burnt\n"
                   + "picture frame lays on the floor, and a strange growth covers much of\n"
                   + "the walls.";
        this.REF = plyr;
    }
/*----------------------------------------------------------------------------*/
    @Override public String triggeredEvent(Room[][][] map) {
        if (! REF.shoes().matches("shrouded shoes")) {
            if (REF.getLastVisited().matches("BHA1"))
                REF.setOccupies(map[3][1][2]);
            else
                REF.setOccupies(map[3][1][4]);
            
            GUI.out("You start pacing down the hallway in a state of vertigo.\n"
                  + "The hallway paradoxically continues to extend onward and warp\n"
                  + "downwards past a close horizon, You stop and look behind you,\n"
                  + "seeing the door you just entered still only several feet away.");
        }
        else
            GUI.out("You pace lightly down the hallway almost effortlessly. You\n"
                  + "no longer have the feeling of being watched. Before long,\n"
                  + "you feel as though you have reached the room's center.");
        
        return "You are " + REF.getOcc() + ".";  
    }
/*----------------------------------------------------------------------------*/
}
