package Tunnels;

import static A_Main.Names.HAND_TORCH;
import A_Super.Direction;
import A_Super.Door;
import A_Super.Item;
/**
 * A metal door, as opposed to wooden doors found in the rest of the castle.
 * @author Kevin Rapa
 */
public class Sew_Door extends Door {
/* CONSTRUCTOR ---------------------------------------------------------------*/        
    public Sew_Door (Direction dir) {
        super(dir);
        this.description = "It's an arched metal door with rivets around the edge.";
        this.NAMEKEYS.remove(1);
        this.addNameKeys("(?:arched )?(?:metal )?door");
    }
//-----------------------------------------------------------------------------
    @Override public String useEvent(Item item) {
        if (item.toString().equals(HAND_TORCH)) 
            return "Could you possibly burn down a metal door?";
        else
            return super.useEvent(item);
        
    }
//-----------------------------------------------------------------------------
}


