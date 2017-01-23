package Back_Balcony;

import A_Super.Furniture;

public class Bba_Columns extends Furniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Bba_Columns() {
        super();
        this.description = "The granite columns are wide and bulging.";
        this.searchDialog = "Nothing on these columns...";
        this.actDialog = "These columns don't need extra help holding up the roof.";
        this.addActKeys("grab", "hold");
        this.addNameKeys("columns?");
    }
/*----------------------------------------------------------------------------*/
}