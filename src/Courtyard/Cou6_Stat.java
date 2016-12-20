package Courtyard;

import Super.Furniture;

public class Cou6_Stat extends Furniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Cou6_Stat() {
        super();
        this.searchable = false;
        this.description = "The statue is just a waist with legs. Part of its\n"
                         + "torso lies on the ground. It probably once depicted\n"
                         + "a male figure.";
        this.searchDialog = "There's nothing on this statue.";
        this.interactDialog = "The statue is rough.";
        this.addActKeys("touch", "grab", "hold");
        this.addNameKeys("statue");
    }
/*----------------------------------------------------------------------------*/
}
