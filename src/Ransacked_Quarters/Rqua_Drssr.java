package Ransacked_Quarters;

import A_Super.Furniture;
        
public class Rqua_Drssr extends Furniture {

/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Rqua_Drssr () {
        super();
        this.searchable = false;
        this.description = "It's a low dresser with a couple opened drawers in it.";
        this.actDialog = "The dresser's drawers are already open.";
        this.searchDialog = "Seems like a bad place to hide something, as someone\n"
                          + "has already searched it.";
        this.addNameKeys("dresser");  
        this.addActKeys("open");
/*----------------------------------------------------------------------------*/
    }
}