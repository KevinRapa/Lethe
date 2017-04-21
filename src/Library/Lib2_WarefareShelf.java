package Library;

import A_Super.Item;
import A_Super.SearchableFurniture;
        
public class Lib2_WarefareShelf extends SearchableFurniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Lib2_WarefareShelf(Item... items) {
        super(items);       
        this.actDialog = "You push against the shelf, but it doesn't budge.";
        this.description = "The tall bookshelf bears a plaque on the top reading "
                         + "\"Warfare\".";
        this.searchDialog = "You peruse its shelves.";
        this.addNameKeys("warfare", "(?:east|right) (?:(?:book)?shelf|one)");
        this.addActKeys(MOVEPATTERN);
    }
//-----------------------------------------------------------------------------
}
