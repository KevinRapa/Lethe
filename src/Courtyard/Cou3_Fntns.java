package Courtyard;

import Super.Furniture;

public class Cou3_Fntns extends Furniture{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Cou3_Fntns(String NAME) {
        super(NAME);
        this.searchable = false;
        this.description = "Crumbling stone fountains to the left and right used\n"
                         + "to decorate the courtyard.";
        this.searchDialog = "They're too far away.";
        this.interactDialog = this.searchDialog;
        this.addNameKeys("fountain", "fountains");
    }
/*----------------------------------------------------------------------------*/
}
