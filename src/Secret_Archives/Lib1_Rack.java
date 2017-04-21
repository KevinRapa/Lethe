package Secret_Archives;

import A_Super.Item;
import A_Super.SearchableFurniture;
import A_Super.Unmoveable;
        
public class Lib1_Rack extends SearchableFurniture implements Unmoveable {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Lib1_Rack(Item... items) {
        super(items);
        this.description = "The wood rack looks like it's meant to hold scrolls, "
                         + "but an equal assortment of scrolls and papers have "
                         + "been stuffed into its crevices.";
        this.searchDialog = "You look through its various nooks and crannies. "
                          + "Here's what you find interesting: ";
        this.addNameKeys("(?:wood(?:en)? )?rack");
    }
//-----------------------------------------------------------------------------
}