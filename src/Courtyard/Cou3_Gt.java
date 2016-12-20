package Courtyard;

import Super.Furniture;

public class Cou3_Gt extends Furniture{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Cou3_Gt() {
        super();
        this.searchable = false;
        this.description = "The monstrous two-story solid oak gate traps you\n"
                         + "inside.";
        this.interactDialog = "It's huge. Even if it were unlocked, you wouldn't be able\n"
                    + "to budge it alone.";
        this.addActKeys("open", "use");
        this.addNameKeys("main gate", "gate", "front gate");
    }
/*----------------------------------------------------------------------------*/
}
