package Drawing_Room;

import Super.Furniture;
import Super.Item;

public class Drar_Br extends Furniture {
    private final Drar_Ghst REF;
/* CONSTRUCTOR ---------------------------------------------------------------*/     
    public Drar_Br(Furniture ghst, Item... items) {
        super();
        this.REF = (Drar_Ghst)ghst;
        this.description = "Behind its solid oak table and chairs, you see a\n"
                         + "shelf populated with many kinds of alcohol.";
        this.searchDialog = "You peruse the bar's shelves.";
        this.addNameKeys("bar");
    }
/*----------------------------------------------------------------------------*/
    @Override public String getSearchDialog() {
        String rep = this.searchDialog;
        
        if (REF.firstTime())
            rep = "Like badass, you completely undermine the ghost in search\n"
                + "of alcohol.";
        
        return rep;
    }
/*----------------------------------------------------------------------------*/
}
