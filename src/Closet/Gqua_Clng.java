package Closet;

import A_Super.Furniture;

public class Gqua_Clng extends Furniture{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gqua_Clng() {
        super();
        this.searchable = false;
        this.description = "It's a low arched cobblestone ceiling.";
        this.searchDialog = "There's nothing here.";
        this.addNameKeys("(?:low )?(?:arched )?(?:cobblestone )?ceiling");
    }
/*----------------------------------------------------------------------------*/
}
