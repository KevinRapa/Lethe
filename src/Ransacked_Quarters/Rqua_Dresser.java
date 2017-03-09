package Ransacked_Quarters;

import A_Super.Furniture;
import A_Super.Moveable;
import A_Super.Openable;
        
public class Rqua_Dresser extends Furniture implements Openable, Moveable {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Rqua_Dresser () {
        super();

        this.description = "It's a low dresser with a couple opened drawers in it.";
        this.actDialog = "There's no reason to do that...";
        this.searchDialog = "Seems like a bad place to hide something, as someone\n"
                          + "has already searched it.";
        this.addActKeys("close");
        this.addNameKeys("(?:low )?dresser");  
/*----------------------------------------------------------------------------*/
    }
}