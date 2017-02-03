package Tunnels;

import A_Super.Direction;
import A_Super.Door;
/**
 * A metal door, as opposed to wooden doors found in the rest of the castle.
 * @author Kevin Rapa
 */
public class Sew_Door extends Door {
/* CONSTRUCTOR ---------------------------------------------------------------*/        
    public Sew_Door (Direction dir) {
        super(dir);
        this.description = "It's an arched metal door with rivets around the edge.";
        this.NAMEKEYS.remove(2);
        this.addNameKeys("(?:arched )?(?:metal )?door");
    }
/*----------------------------------------------------------------------------*/
}


