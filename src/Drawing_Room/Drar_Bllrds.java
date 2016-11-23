package Drawing_Room;

import Super.Furniture;
import Super.Item;
import Super.Room;

public class Drar_Bllrds extends Furniture {
    private final Drar_Ghst REF;
/* CONSTRUCTOR ---------------------------------------------------------------*/     
    public Drar_Bllrds(String NAME, Furniture ghst, Item ... items) {
        super(NAME);
        this.REF = (Drar_Ghst)ghst;
        this.description = "The billiard table is clothed in the typical green,\n"
                         + "though the pockets are missing...";
        this.searchDialog = "You look on the table's surface.";
        this.interactDialog = "What in the... this is a rich people's billiard table\n"
                            + "with no pockets. You can't play this.";
        this.addNameKeys("billiard table", "pool table");
        this.addActKeys("play", "use");
    }
/*----------------------------------------------------------------------------*/
    @Override public String getSearchDialog() {
        String rep = this.searchDialog;
        
        if (REF.firstTime())
            rep = "Ignoring the ghost completely, you look on the billiard\n"
                + "table's surface.";
        
        return rep;
    }
/*----------------------------------------------------------------------------*/
        @Override public String interact(Room[][][] map, String key) {
        String rep = this.interactDialog;
        
        if (REF.firstTime())
            rep = "Now is not the time for that. There's a ghost in here!";
        
        return rep;
    }
/*----------------------------------------------------------------------------*/
}
