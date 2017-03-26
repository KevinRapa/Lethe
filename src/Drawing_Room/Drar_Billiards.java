package Drawing_Room;

import A_Super.Furniture;
import A_Super.Item;
import A_Super.Moveable;
import A_Super.SearchableFurniture;

public class Drar_Billiards extends SearchableFurniture implements Moveable {
    private final Drar_Ghost GHOST_REF;
/* CONSTRUCTOR ---------------------------------------------------------------*/     
    public Drar_Billiards(Furniture ghst, Item... items) {
        super();
        this.GHOST_REF = (Drar_Ghost)ghst;
        this.description = "The billiard table is clothed in the typical green, "
                         + "though the pockets are missing...";
        this.searchDialog = "You look on the table's surface.";
        this.actDialog = "What in the... this is a rich people's billiard table "
                       + "with no pockets. You can't play this.";
        this.addNameKeys("billiard table", "pool(?: table)?", "billiards");
        this.addActKeys("play", "use");
    }
/*----------------------------------------------------------------------------*/
    @Override public String getSearchDialog() {
        if (GHOST_REF.firstTime())
            return "Ignoring the ghost completely, you look on the billiard table's surface.";
        else 
            return this.searchDialog;
    }
/*----------------------------------------------------------------------------*/
    @Override public String interact(String key) {
        if (GHOST_REF.firstTime())
            return "Now is not the time for that. There's a ghost in here!";
        else
            return this.actDialog;
    }
/*----------------------------------------------------------------------------*/
}
