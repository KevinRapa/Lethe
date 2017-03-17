package Drawing_Room;

import A_Super.Item;
import A_Super.SearchableFurniture;

public class Drar_Bar extends SearchableFurniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/     
    public Drar_Bar(Item... items) {
        super(items);
        
        this.description = "Behind its solid oak table and chairs, you see a\n"
                         + "shelf populated with many kinds of alcohol.";
        this.searchDialog = "You peruse the bar's shelves.";
        this.actDialog = "A drink sounds like a good idea right about now. All the alcohol\n"
                       + "here must be stale and bitter by now though.";
        
        this.addActKeys(SITPATTERN, "drink");
        this.addNameKeys("bar|shelf|alcohol|wine|beer|liquor");
    }
/*----------------------------------------------------------------------------*/
}
