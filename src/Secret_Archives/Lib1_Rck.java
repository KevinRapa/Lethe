package Secret_Archives;

import Super.Furniture;
import Super.Item;
        
public class Lib1_Rck extends Furniture {

/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Lib1_Rck(String NAME, Item ... items) {
        super(NAME, items);
        this.description = "The wood rack looks like it's meant to hold scrolls,\n"
                         + "but an equal assortment of scrolls and papers have\n"
                         + "been stuffed into its crevices.";
        this.searchDialog = "You look through its various nooks and crannies.\n"
                          + "Here's what you find interesting: ";
        this.addNameKeys("rack");
    }
/*----------------------------------------------------------------------------*/
}