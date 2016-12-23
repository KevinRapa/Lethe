package Back_Balcony;

import A_Super.Furniture;

public class Bba_Rf extends Furniture{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Bba_Rf() {
        super();
        this.searchable = false;
        this.description = "Just a blank ceiling.";
        this.actDialog = "You extend your arm and poke the ceiling.";
        this.addActKeys("touch", "poke");
        this.addNameKeys("ceiling", "cieling", "roof");
    }
/*----------------------------------------------------------------------------*/  
}
