package Vestibule;

import A_Super.Furniture;

public class Vest_EndTable extends Furniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Vest_EndTable() {
        super();

        this.description = "An round, ornate, wooden end table. A ceramic\n" +
                           "case rests on top.";
        this.searchDialog = "The table does not seem to be hiding anything.\n" +
                            "The case on top looks tempting, however.";
        this.actDialog = "Jostling the table a little, you find its\n" +
                         "craftsmanship impressive. The carvings on it are\n" + 
                         "equally such.";
        this.addNameKeys("(?:wood(?:en)? )?(?:end )?table");
        this.addActKeys(JOSTLEPATTERN);
    }
/*----------------------------------------------------------------------------*/    
}
