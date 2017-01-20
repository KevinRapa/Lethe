package Tunnels;

import A_Super.Direction;
import A_Super.Door;

public class Sew_Door extends Door {
/* CONSTRUCTOR ---------------------------------------------------------------*/        
    public Sew_Door (Direction dir) {
        super(dir);
        this.description = "It's an arched metal door with rivets around the edge.";
        this.NAMEKEYS.remove(2);
        this.NAMEKEYS.add("(?:arched )?(?:metal )?door");
    }
/*----------------------------------------------------------------------------*/
}


