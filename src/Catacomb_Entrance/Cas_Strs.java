package Catacomb_Entrance;

import A_Super.Direction;
import A_Super.Staircase;
/**
 * @author Kevin Rapa
 */
public class Cas_Strs extends Staircase {

    // ========================================================================
    public Cas_Strs (Direction dir) {
        super(dir, 1);
        
        this.description = "The two curved stone staircases both lead " + dir + ".";

        this.addNameKeys("curved (?:staircase|stairs|steps)");
    }
    // ======================================================================== 
}


