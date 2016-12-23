package Ransacked_Quarters;

import A_Super.Furniture;
        
public class Rqua_Mttrss extends Furniture {

/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Rqua_Mttrss () {
        super();
        this.searchable = false;
        this.description = "It's a debris-covered mattress.";
        this.searchDialog = "Nothing here. It's a bad place to hide something,\n"
                          + "as someone has already searched it.";
        this.actDialog = "It's really not the time for sleeping now.";
        this.addNameKeys("mattress", "debris-covered mattress");
        this.addActKeys("sleep", "lay", "relax");
    }
/*----------------------------------------------------------------------------*/
}

