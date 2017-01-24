package A_Super;

import A_Main.Inventory;
/**
 * Made so that not ALL furniture have inventories, just one's that can hold
 * items.
 * 
 * @author Kevin Rapa
 */
abstract public class SearchableFurniture extends Furniture {
    // ========================================================================
    public SearchableFurniture (Item... items) {
        super();
        this.inv = new Inventory(items);
        this.searchable = true;
    }
    // ========================================================================    
}


