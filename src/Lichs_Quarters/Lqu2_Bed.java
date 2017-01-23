package Lichs_Quarters;

import A_Super.Furniture;
/**
 * @author Kevin Rapa
 */
public class Lqu2_Bed extends Furniture {
    // ========================================================================
    public Lqu2_Bed () {
        super();

        this.description = "It seems he will not have to roam eternally in madness after all...\n"
                         + "you suppose someone will find him eventually? Not great to just leave a dead body alone. Oh well.";
        this.searchDialog = "There's no reason...";

        this.addNameKeys("(?:lifeless )?(?:innocent )?body", "bed");
    }
    // ========================================================================  
}


