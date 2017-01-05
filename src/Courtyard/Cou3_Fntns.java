package Courtyard;

import A_Super.Furniture;

public class Cou3_Fntns extends Furniture{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Cou3_Fntns() {
        super();
        this.searchable = false;
        this.description = "Crumbling stone fountains to the left and right used\n"
                         + "to decorate the courtyard.";
        this.searchDialog = "They're too far away.";
        this.actDialog = this.searchDialog;
        this.addNameKeys("(?:crumbling )?(?:stone )?fountains?");
    }
/*----------------------------------------------------------------------------*/
}
