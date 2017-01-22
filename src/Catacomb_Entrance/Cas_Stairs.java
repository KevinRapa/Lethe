package Catacomb_Entrance;

import A_Super.Direction;
import A_Super.Staircase;
/**
 * @author Kevin Rapa
 */
public class Cas_Stairs extends Staircase {
    // ========================================================================
    public Cas_Stairs (Direction dir) {
        super(dir);
        
        this.description = "The two curved stone staircases both lead " + dir + ".";

        this.addNameKeys("curved (?:staircases?|stairs|steps)");
    }
    // ======================================================================== 
}


