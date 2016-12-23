package Kitchen;

import A_Super.Furniture;
import A_Super.Item;
        
public class Kitc_Shlf extends Furniture {

/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Kitc_Shlf(Item... items) {
        super(items);
        this.description = "The tall shelf is filled with old wines.";
        this.searchDialog = "You peruse the wine selection.";
        this.addNameKeys("shelf of wine", "wine shelf", "wine rack", "shelf", "wine");
    }
/*----------------------------------------------------------------------------*/
}
