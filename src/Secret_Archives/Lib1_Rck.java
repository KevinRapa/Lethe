package Secret_Archives;

import A_Super.Furniture;
import A_Super.Item;
        
public class Lib1_Rck extends Furniture {

/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Lib1_Rck(Item... items) {
        super(items);
        this.description = "The wood rack looks like it's meant to hold scrolls,\n"
                         + "but an equal assortment of scrolls and papers have\n"
                         + "been stuffed into its crevices.";
        this.searchDialog = "You look through its various nooks and crannies.\n"
                          + "Here's what you find interesting: ";
        this.addNameKeys("rack");
    }
/*----------------------------------------------------------------------------*/
}