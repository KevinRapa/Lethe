package Drawing_Room;

import A_Super.Furniture;

public class Drar_Cch extends Furniture {
    private final Drar_Ghst GHOST_REF;
/* CONSTRUCTOR ---------------------------------------------------------------*/     
    public Drar_Cch(Furniture ghst) {
        super();
        this.GHOST_REF = (Drar_Ghst)ghst;
        this.searchable = false;
        this.description = "The victorian-era couch is a bold green color. This\n"
                         + "one looks quite comfortable actually.";
        this.searchDialog = "There's nothing hidden on this couch.";
        this.actDialog = "This is the most comfortable couch you've sat in yet.\n"
                            + "Why haven't you grabbed a drink?";
        this.addActKeys("sit", "relax", "lay");
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
