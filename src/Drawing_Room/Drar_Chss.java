package Drawing_Room;

import A_Super.Furniture;
import A_Super.Item;

public class Drar_Chss extends Furniture {
    private final Drar_Ghst REF;
/* CONSTRUCTOR ---------------------------------------------------------------*/     
    public Drar_Chss(Furniture ghst, Item... items) {
        super(items);
        this.REF = (Drar_Ghst)ghst;
        this.description = "The fancy chess table bears a polished ceramic\n"
                         + "surface and many detailed pieces. You wish you\n"
                         + "knew how to play.";
        this.searchDialog = "You look on the table's surface.";
        this.actDialog = "'I aren't smart enough to play this' you speak softly\n"
                       + "in soliloquy.";
        this.addActKeys("play");
        this.addNameKeys("(?:fancy )?chess table");
    }
/*----------------------------------------------------------------------------*/
    @Override public String getSearchDialog() {
        if (REF.firstTime())
            return "Ignoring the ghost completely, you search the chess\n"
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