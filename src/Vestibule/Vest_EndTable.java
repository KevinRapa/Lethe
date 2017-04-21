package Vestibule;

import A_Super.Furniture;
import A_Super.Moveable;

public class Vest_EndTable extends Furniture implements Moveable {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Vest_EndTable() {
        super();

        this.description = "An round, ornate, wooden end table. A ceramic " +
                           "case rests on top.";
        this.searchDialog = "The table does not seem to be hiding anything. " +
                            "The case on top looks tempting, however.";
        this.actDialog = "Jostling the table a little, you find its " +
                         "craftsmanship impressive. The carvings on it are " + 
                         "equally such.";
        this.addNameKeys("(?:wood(?:en)? )?(?:end )?table");
        this.addActKeys(JOSTLEPATTERN);
    }
//-----------------------------------------------------------------------------    
}
