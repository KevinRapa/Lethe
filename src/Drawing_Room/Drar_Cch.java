package Drawing_Room;

import Super.Furniture;

public class Drar_Cch extends Furniture {
    private final Drar_Ghst REF;
/* CONSTRUCTOR ---------------------------------------------------------------*/     
    public Drar_Cch(Furniture ghst) {
        super();
        this.REF = (Drar_Ghst)ghst;
        this.searchable = false;
        this.description = "The victorian-era couch is a bold green color. This\n"
                         + "one looks quite comfortable actually.";
        this.searchDialog = "There's nothing hidden on this couch.";
        this.interactDialog = "This is the most comfortable couch you've sat in yet.\n"
                            + "Why haven't you grabbed a drink?";
        this.addActKeys("sit", "relax", "lay");
        this.addNameKeys("couch");
    }
/*----------------------------------------------------------------------------*/
    @Override public String getSearchDialog() {
        String rep = this.searchDialog;
        
        if (REF.firstTime())
            rep = "You do realize that there's a ghost in here, right?";
        
        return rep;
    }
/*----------------------------------------------------------------------------*/
        @Override public String interact(String key) {
        String rep = this.interactDialog;
        
        if (REF.firstTime())
            rep = "You do realize that there's a ghost in here, right?";
        
        return rep;
    }
/*----------------------------------------------------------------------------*/
}
