package Ransacked_Quarters;

import A_Super.Furniture;
import A_Super.Moveable;
        
public class Rqua_Mattress extends Furniture implements Moveable{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Rqua_Mattress () {
        super();

        this.description = "It's a debris-covered mattress thrown carelessly "
                         + "on the floor.";
        this.searchDialog = "Nothing here. It's a bad place to hide something, "
                          + "as someone has already searched it.";
        this.actDialog = "It's really not the time for sleeping now.";
        this.addNameKeys("mattress", "debris-covered mattress");
        this.addActKeys(SITPATTERN);
    }
//-----------------------------------------------------------------------------
}

