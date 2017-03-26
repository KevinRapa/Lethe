package Secret_Archives;

import A_Super.Item;
import A_Super.SearchableFurniture;
import A_Super.Unmoveable;
        
public class Lib1_Table extends SearchableFurniture implements Unmoveable {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Lib1_Table(Item... items) {
        super(items);
        this.description = "The table is ornate, with curved legs, and bears "
                         + "a bizarre stone head emitting light from an unknown "
                         + "source.";
        this.searchDialog = "You fan through the boring papers scattered around "
                          + "the artifact. Here's what you find interesting: ";
        this.actDialog = "You give it a kick. A thick woody clunk inundates your ear holes, and you are enticed to hit it again.";
        
        this.addActKeys(JOSTLEPATTERN);
        this.addNameKeys("(?:ornate )?table");
    }
/*----------------------------------------------------------------------------*/
}
