package Drawing_Room;

import A_Super.Furniture;
import A_Super.Item;
import A_Super.SearchableFurniture;

public class Drar_Bar extends SearchableFurniture {
    private final Drar_Ghost GHOST_REF;
/* CONSTRUCTOR ---------------------------------------------------------------*/     
    public Drar_Bar(Furniture ghst, Item... items) {
        super(items);
        this.GHOST_REF = (Drar_Ghost)ghst;
        
        this.description = "Behind its solid oak table and chairs, you see a\n"
                         + "shelf populated with many kinds of alcohol.";
        this.searchDialog = "You peruse the bar's shelves.";
        this.actDialog = "A drink sounds like a good idea right about now. All the alcohol\n"
                       + "here must be stale and bitter by now though.";
        
        this.addActKeys("sit");
        this.addNameKeys("bar", "shelf", "alcohol", "wine", "beer", "liquor");
    }
/*----------------------------------------------------------------------------*/
    @Override public String getSearchDialog() {
        if (GHOST_REF.firstTime())
            return "As a common drunk, you completely undermine the ghost in search of alcohol.";
        else
            return this.searchDialog;
    }
/*----------------------------------------------------------------------------*/
}
