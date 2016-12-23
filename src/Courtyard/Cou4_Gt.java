package Courtyard;

import A_Super.Furniture;

public class Cou4_Gt extends Furniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Cou4_Gt() {
        super();
        this.searchable = false;
        this.description = "It's a monstrous two-story solid oak gate.";
        this.actDialog = "It's open already.";
        this.addActKeys("open", "use");
        this.addNameKeys("main gate", "gate", "front gate");
    }
/*----------------------------------------------------------------------------*/
}
