package Drawing_Room;

import A_Super.Furniture;
import A_Super.Item;

public class Drar_Table extends Furniture {
    private final Drar_Ghost GHOST_REF;
/* CONSTRUCTOR ---------------------------------------------------------------*/     
    public Drar_Table(Furniture ghst, Item... items) {
        super();
        this.GHOST_REF = (Drar_Ghost)ghst;
        this.description = "The low coffee table is glossy and clean.";
        this.searchDialog = "You look on the table's surface.";
        this.addNameKeys("(?:low )?(?:coffee )?table");
    }
/*----------------------------------------------------------------------------*/
    @Override public String getSearchDialog() {
        if (GHOST_REF.firstTime())
            return "Ignoring the ghost completely, you comb the table's\n"
                 + "surface.";
        
        return this.searchDialog;
    }
/*----------------------------------------------------------------------------*/
}
