package Keeper_Chamber;

import A_Super.Furniture;
/**
 * @author Kevin Rapa
 */
public class Dkch_Ceiling extends Furniture {
    // ========================================================================
    public Dkch_Ceiling () {
        super();

        this.description = "The low ceiling arches to the floor on the chamber's\n"
                         + "east side.";

        this.addNameKeys("(?:arched )?ceiling");
    }
    // ========================================================================   
}

