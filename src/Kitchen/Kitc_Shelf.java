package Kitchen;

import A_Super.Item;
import A_Super.SearchableFurniture;
        
public class Kitc_Shelf extends SearchableFurniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Kitc_Shelf(Item... items) {
        super(items);
        this.description = "The tall shelf is filled with old wines.";
        this.searchDialog = "You peruse the wine selection.";
        this.actDialog = "Do you really want wine and broken glass everywhere?";
        
        this.addActKeys(JOSTLEPATTERN);
        this.addNameKeys("shelf of wine", "wine(?: shelf| rack)?", "shelf");
    }
/*----------------------------------------------------------------------------*/
}
