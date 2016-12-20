package Kitchen;

import Super.Furniture;
import Super.Item;
        
public class Kitc_Shlf extends Furniture {

/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Kitc_Shlf(Item... items) {
        super(items);
        this.description = "The tall shelf is filled with old wines.";
        this.searchDialog = "You peruse the wine selection.";
        this.addNameKeys("shelf of", "wine shelf", "wine rack", "shelf", "wine");
    }
/*----------------------------------------------------------------------------*/
}
