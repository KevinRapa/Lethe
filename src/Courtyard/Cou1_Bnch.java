package Courtyard;

import Super.Furniture;

public class Cou1_Bnch extends Furniture{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Cou1_Bnch(String NAME) {
        super(NAME);
        this.searchable = false;
        this.description = "The bench is blanketed in multiflora. Its backrest\n"
                         + "lies on the ground behind it.";
        this.searchDialog = "You aren't risking getting pricked by those thorns.";
        this.interactDialog = "You aren't risking getting pricked by those thorns.";
        this.addActKeys("sit", "relax", "lay");
        this.addNameKeys("bench", "stone bench");
    }
/*----------------------------------------------------------------------------*/
}
