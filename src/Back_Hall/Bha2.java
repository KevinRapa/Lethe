package Back_Hall;

import A_Super.Room;
import A_Main.Player;
import A_Main.GUI;
import A_Main.Id;
/**
 * Sends player back to BHA1 if the player is not wearing the enchanted shoes.
 * Supposed to generate the illusion that the hallway is infinitely long.
 * 
 * @see Parlor.Par1_EnchtTbl#enchant()
 * @author Kevin Rapa
 */
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
            if (Player.getLastVisited().matches(Id.BHA1))
                Player.setOccupies(Id.BHA1);
            else
                Player.setOccupies(Id.BHA3);
            
            GUI.out("You start pacing down the hallway in a state of vertigo.\n"
                  + "The hallway paradoxically continues to extend onward and warp\n"
                  + "downwards past a nearby horizon. After a short while, you stop and look behind you,\n"
                  + "seeing the door you just entered still only several feet away.");
        }
        else
            GUI.out("You pace lightly down the hallway almost effortlessly. You\n"
                  + "break free from your state of vertigo. Before long,\n"
                  + "you feel as though you have reached the room's center.");
        
        return "You are " + Player.getPos() + ".";  
    }
/*----------------------------------------------------------------------------*/
}
