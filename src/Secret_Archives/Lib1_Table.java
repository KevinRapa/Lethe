package Secret_Archives;

import A_Super.Item;
import A_Super.SearchableFurniture;
        
public class Lib1_Table extends SearchableFurniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Lib1_Table(Item... items) {
        super(items);
        this.description = "The table is ornate, with curved legs, and bears\n"
                         + "a bizarre stone head emitting light from an unknown\n"
                         + "source.";
        this.searchDialog = "You fan through the boring papers scattered around\n"
                          + "the artifact. Here's what you find interesting: ";
        this.actDialog = "You give it a kick. A thick woody clunk inundates your earholes, and you are enticed to hit it again.";
        
        this.addActKeys(JOSTLEPATTERN);
        this.addNameKeys("(?:ornate )?table");
    }
/*----------------------------------------------------------------------------*/
}
