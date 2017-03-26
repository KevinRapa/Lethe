package Drawing_Room;

import A_Super.Furniture;
import A_Super.Item;
import A_Super.Moveable;
import A_Super.SearchableFurniture;

public class Drar_Chess extends SearchableFurniture implements Moveable {
    private final Drar_Ghost GHOST_REF;
/* CONSTRUCTOR ---------------------------------------------------------------*/     
    public Drar_Chess(Furniture ghst, Item... items) {
        super(items);
        this.GHOST_REF = (Drar_Ghost)ghst;
        this.description = "The fancy chess table bears a polished ceramic "
                         + "surface and many detailed pieces. You wish you "
                         + "knew how to play.";
        this.searchDialog = "You look on the table's surface.";
        this.actDialog = "'I aren't smart enough to play this' you speak softly "
                       + "in soliloquy.";
        this.addActKeys("play");
        this.addNameKeys("(?:fancy )?chess table", "chess");
    }
/*----------------------------------------------------------------------------*/
    @Override public String getSearchDialog() {
        if (GHOST_REF.firstTime())
            return "Ignoring the ghost completely, you search the chess "
                 + "table's surface.";
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