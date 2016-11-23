package Back_Balcony;

import Super.Furniture;

public class Bba_Rf extends Furniture{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Bba_Rf(String NAME) {
        super(NAME);
        this.searchable = false;
        this.description = "Just a blank ceiling.";
        this.interactDialog = "You extend your arm and poke the ceiling.";
        this.addActKeys("touch", "poke");
        this.addNameKeys("ceiling", "cieling", "roof");
    }
/*----------------------------------------------------------------------------*/  
}
