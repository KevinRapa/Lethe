package Secret_Archives;

import Super.Furniture;
import Super.Item;
        
public class Lib1_Tbl extends Furniture {

/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Lib1_Tbl(Item... items) {
        super(items);
        this.description = "The table is ornate, with curved legs, and bears\n"
                         + "a bizarre stone head emitting light from an unknown\n"
                         + "source.";
        this.searchDialog = "You fan through the boring papers scattered around\n"
                          + "the artifact. Here's what you find interesting: ";
        this.addNameKeys("table");
    }
/*----------------------------------------------------------------------------*/
}
