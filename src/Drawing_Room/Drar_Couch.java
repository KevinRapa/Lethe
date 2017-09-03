package Drawing_Room;

import A_Main.Player;
import A_Super.Furniture;
import A_Super.Moveable;

public class Drar_Couch extends Furniture implements Moveable {
    private final int GHOST_ID;
/* CONSTRUCTOR ---------------------------------------------------------------*/     
    public Drar_Couch(Furniture ghst) {
        super();
        this.GHOST_ID = ghst.getID();

        this.description = "The Victorian-era couch is a bold green color. This "
                         + "one looks quite comfortable actually.";
        this.searchDialog = "There's nothing hidden on this couch.";
        this.actDialog = "This is the most comfortable couch you've sat in yet. "
                            + "Why haven't you grabbed a drink?";
        this.addActKeys(SITPATTERN);
        this.addNameKeys("(?:(?:bold )?green )?(?:victorian-era )?couch");
    }
//-----------------------------------------------------------------------------
    @Override public String getSearchDialog() {
        Drar_Ghost g = (Drar_Ghost)Player.getPos().getFurnRef(GHOST_ID);
        
        if (g.firstTime())
            return "You do realize that there's a ghost in here, right?";
        
        return this.searchDialog;
    }
//-----------------------------------------------------------------------------
    @Override public String interact(String key) {
        Drar_Ghost g = (Drar_Ghost)Player.getPos().getFurnRef(GHOST_ID);
        
        if (g.firstTime())
            return "You do realize that there's a ghost in here, right?";
        
        return this.actDialog;
    }
//-----------------------------------------------------------------------------
}
