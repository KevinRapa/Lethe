package Drawing_Room;

import Super.Furniture;
import Super.Item;

public class Drar_Tbl extends Furniture {
    private final Drar_Ghst REF;
/* CONSTRUCTOR ---------------------------------------------------------------*/     
    public Drar_Tbl(Furniture ghst, Item... items) {
        super();
        this.REF = (Drar_Ghst)ghst;
        this.description = "The low coffee table is glossy and clean.";
        this.searchDialog = "You look on the table's surface.";
        this.addNameKeys("table", "low table", "coffee table");
    }
/*----------------------------------------------------------------------------*/
    @Override public String getSearchDialog() {
        String rep = this.searchDialog;
        
        if (REF.firstTime())
            rep = "Ignoring the ghost completely, you comb the table's\n"
                + "surface.";
        
        return rep;
    }
/*----------------------------------------------------------------------------*/
}
