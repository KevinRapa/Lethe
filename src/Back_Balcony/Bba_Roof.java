package Back_Balcony;

import A_Super.Furniture;

public class Bba_Roof extends Furniture{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Bba_Roof() {
        super();
        this.description = "Just a blank ceiling.";
        this.actDialog = "You extend your arm and poke the ceiling.";
        this.addActKeys("touch", "poke");
        this.addNameKeys("ceiling", "roof");
    }
/*----------------------------------------------------------------------------*/  
}
