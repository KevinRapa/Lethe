package Drawing_Room;

import A_Super.Furniture;
import A_Super.Item;

public class Drar_Bllrds extends Furniture {
    private final Drar_Ghst REF;
/* CONSTRUCTOR ---------------------------------------------------------------*/     
    public Drar_Bllrds(Furniture ghst, Item... items) {
        super();
        this.REF = (Drar_Ghst)ghst;
        this.description = "The billiard table is clothed in the typical green,\n"
                         + "though the pockets are missing...";
        this.searchDialog = "You look on the table's surface.";
        this.actDialog = "What in the... this is a rich people's billiard table\n"
                       + "with no pockets. You can't play this.";
        this.addNameKeys("billiard table", "pool table");
        this.addActKeys("play", "use");
    }
/*----------------------------------------------------------------------------*/
    @Override public String getSearchDialog() {
        if (REF.firstTime())
            return "Ignoring the ghost completely, you look on the billiard\n"
                + "table's surface.";
        
        return this.searchDialog;
    }
/*----------------------------------------------------------------------------*/
    @Override public String interact(String key) {
        if (REF.firstTime())
            return "Now is not the time for that. There's a ghost in here!";
        
        return this.actDialog;
    }
/*----------------------------------------------------------------------------*/
}
