package Back_Hall;

import A_Super.Room;
import A_Main.Player;
import A_Main.GUI;
import A_Main.Id;
import static A_Main.Names.SHROUDED_SHOES;
/**
 * Sends player back to BHA1 if the player is not wearing the enchanted shoes.
 * Supposed to generate the illusion that the hallway is infinitely long.
 * Connects to Bha1 and Bha2
 * 
 * @see Back_Hall.Bha2
 * @see Back_Hall.Bha1
 * @see Parlor.Par1_EnchantingTable
 * @author Kevin Rapa
 */
public class Bha2 extends Room {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Bha2(String name, String ID) {
        super(name, ID);
    }
//-----------------------------------------------------------------------------
    @Override public String triggeredEvent() {
        if (! Player.getShoes().equals(SHROUDED_SHOES)) {
            if (Player.getLastVisited().equals(Id.BHA1))
                Player.setOccupies(Id.BHA1);
            else
                Player.setOccupies(Id.BHA3);
            
            GUI.out("You start pacing down the hallway in a state of vertigo. "
                  + "The hallway paradoxically continues to extend onward and warp "
                  + "downwards past a nearby horizon. After a short while, you stop and look behind you, "
                  + "seeing the door you just entered still only several feet away.");
            return Player.getPos().toString();
        }
        else {
            GUI.out("You pace lightly down the hallway almost effortlessly. You "
                  + "break free from your state of vertigo. Before long, "
                  + "you feel as though you have reached the room's center.");
            return NAME;  
        }
    }
//-----------------------------------------------------------------------------
}
