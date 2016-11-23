package Back_Balcony;

import Super.Furniture;

public class Bba_Clmns extends Furniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Bba_Clmns(String NAME) {
        super(NAME);
        this.searchable = false;
        this.description = "The granite columns are wide and bulging.";
        this.searchDialog = "Nothing on these columns...";
        this.interactDialog = "These columns don't need extra help holding up the roof.";
        this.addActKeys("grab", "hold");
        this.addNameKeys("columns, column");
    }
/*----------------------------------------------------------------------------*/
}