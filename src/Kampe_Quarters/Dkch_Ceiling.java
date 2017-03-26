package Kampe_Quarters;

import A_Super.Furniture;
/**
 * @author Kevin Rapa
 */
public class Dkch_Ceiling extends Furniture {
    // ========================================================================
    public Dkch_Ceiling () {
        super();

        this.description = "The low ceiling arches to the floor on the chamber's "
                         + "east side.";

        this.addNameKeys("(?:arched )?ceiling");
    }
    // ========================================================================   
}


