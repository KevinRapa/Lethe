package Closet;

import A_Super.Furniture;

public class Gqua_Ceiling extends Furniture{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gqua_Ceiling() {
        super();

        this.description = "It's a low arched cobblestone ceiling.";
        this.searchDialog = "There's nothing here.";
        this.addNameKeys("(?:low )?(?:arched )?(?:cobblestone )?ceiling");
    }
/*----------------------------------------------------------------------------*/
}
