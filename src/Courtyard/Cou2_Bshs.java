package Courtyard;

import Super.Furniture;

public class Cou2_Bshs extends Furniture{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Cou2_Bshs() {
        super();
        this.searchable = false;
        this.description = "They're unkept rose bushes, and probably the only\n"
                         + "pretty things in this yard.";
        this.searchDialog = "You aren't getting pricked by those thorns.";
        this.interactDialog = "You aren't getting pricked by those thorns.";
        this.addActKeys("grab", "hold", "touch");
        this.addNameKeys("bushes", "unkept bushes");
    }
/*----------------------------------------------------------------------------*/
}
