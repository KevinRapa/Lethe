package Vestibule;

import Super.Furniture;

public class Vest_Etbl extends Furniture {

/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Vest_Etbl(String NAME) {
        super(NAME);
        this.searchable = false;
        this.description = "An round, ornate, wooden end table. A ceramic\n" +
                           "case rests on top.";
        this.searchDialog = "The table does not seem to be hiding anything.\n" +
                            "The case on top looks tempting, however.";
        this.interactDialog = "Jostling the table a little, you find its\n" +
                      "craftsmanship impressive. The carvings on it are\n" + 
                      "equally such.";
        this.addNameKeys("wood table", "end table", "table", "wooden table");
        this.addActKeys("move", "kick");
    }
/*----------------------------------------------------------------------------*/    
}
