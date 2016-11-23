package Courtyard;

import Super.Furniture;

public class Cou4_Trl extends Furniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Cou4_Trl(String NAME) {
        super(NAME);
        this.searchable = false;
        this.description = "The winding trail extends back into the dark forest.";
        this.interactDialog = "You feel compelled to enter through the front gate.";
        this.addActKeys("walk");
        this.addNameKeys("trail", "dark trail", "long trail");
    }
/*----------------------------------------------------------------------------*/
}
