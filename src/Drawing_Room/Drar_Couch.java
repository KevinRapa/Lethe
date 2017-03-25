package Drawing_Room;

import A_Super.Furniture;
import A_Super.Moveable;

public class Drar_Couch extends Furniture implements Moveable {
    private final Drar_Ghost GHOST_REF;
/* CONSTRUCTOR ---------------------------------------------------------------*/     
    public Drar_Couch(Furniture ghst) {
        super();
        this.GHOST_REF = (Drar_Ghost)ghst;

        this.description = "The Victorian-era couch is a bold green color. This\n"
                         + "one looks quite comfortable actually.";
        this.searchDialog = "There's nothing hidden on this couch.";
        this.actDialog = "This is the most comfortable couch you've sat in yet.\n"
                            + "Why haven't you grabbed a drink?";
        this.addActKeys(SITPATTERN);
        this.addNameKeys("(?:(?:bold )?green )?(?:victorian-era )?couch");
    }
/*----------------------------------------------------------------------------*/
    @Override public String getSearchDialog() {
        if (GHOST_REF.firstTime())
            return "You do realize that there's a ghost in here, right?";
        
        return this.searchDialog;
    }
/*----------------------------------------------------------------------------*/
    @Override public String interact(String key) {
        if (GHOST_REF.firstTime())
            return "You do realize that there's a ghost in here, right?";
        
        return this.actDialog;
    }
/*----------------------------------------------------------------------------*/
}
