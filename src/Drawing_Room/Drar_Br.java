package Drawing_Room;

import A_Super.Furniture;
import A_Super.Item;

public class Drar_Br extends Furniture {
    private final Drar_Ghst REF;
/* CONSTRUCTOR ---------------------------------------------------------------*/     
    public Drar_Br(Furniture ghst, Item... items) {
        super();
        this.REF = (Drar_Ghst)ghst;
        this.description = "Behind its solid oak table and chairs, you see a\n"
                         + "shelf populated with many kinds of alcohol.";
        this.searchDialog = "You peruse the bar's shelves.";
        this.addNameKeys("bar", "shelf");
    }
/*----------------------------------------------------------------------------*/
    @Override public String getSearchDialog() {
        if (REF.firstTime())
            return "As a common drunk, you completely undermine the ghost in search\n"
                 + "of alcohol.";
        
        return this.searchDialog;
    }
/*----------------------------------------------------------------------------*/
}
