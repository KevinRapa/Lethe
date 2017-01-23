package Kitchen;

import A_Super.Item;
import A_Super.SearchableFurniture;
        
public class Kitc_Shelf extends SearchableFurniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Kitc_Shelf(Item... items) {
        super(items);
        this.description = "The tall shelf is filled with old wines.";
        this.searchDialog = "You peruse the wine selection.";
        this.addNameKeys("shelf of wine", "wine shelf", "wine rack", "shelf", "wine");
    }
/*----------------------------------------------------------------------------*/
}
