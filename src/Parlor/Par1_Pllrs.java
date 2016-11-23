package Parlor;

import Super.Furniture;

public class Par1_Pllrs extends Furniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/      
    public Par1_Pllrs(String NAME) {
            super(NAME);
            this.searchable = false;
            this.addNameKeys("pillars", "pillar", "column", "columns");
            this.description = "The tan, grooved columns support the loft extension.";
    }
/*----------------------------------------------------------------------------*/    
}
