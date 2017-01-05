package Drawing_Room;

import A_Super.Furniture;
import A_Super.Item;

public class Drar_Tbl extends Furniture {
    private final Drar_Ghst REF;
/* CONSTRUCTOR ---------------------------------------------------------------*/     
    public Drar_Tbl(Furniture ghst, Item... items) {
        super();
        this.REF = (Drar_Ghst)ghst;
        this.description = "The low coffee table is glossy and clean.";
        this.searchDialog = "You look on the table's surface.";
        this.addNameKeys("(?:low )?(?:coffee )?table");
    }
/*----------------------------------------------------------------------------*/
    @Override public String getSearchDialog() {
        if (REF.firstTime())
            return "Ignoring the ghost completely, you comb the table's\n"
                 + "surface.";
        
        return this.searchDialog;
    }
/*----------------------------------------------------------------------------*/
}
