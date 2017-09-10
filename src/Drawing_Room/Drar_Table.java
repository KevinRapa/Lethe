package Drawing_Room;

import A_Main.Player;
import A_Super.Furniture;
import A_Super.Item;
import A_Super.Moveable;
import A_Super.SearchableFurniture;

public class Drar_Table extends SearchableFurniture implements Moveable {
    private final int GHOST_ID;
/* CONSTRUCTOR ---------------------------------------------------------------*/     
    public Drar_Table(Furniture ghst, Item... items) {
        super(items);
        this.GHOST_ID = ghst.getID();
        this.description = "The low coffee table is glossy and clean.";
        this.searchDialog = "You look on the table's surface.";
        this.actDialog= "How shameful it would be to dirty the table. Let's not touch it.";
        
        this.addUseKeys(JOSTLEPATTERN);
        this.addNameKeys("(?:low )?(?:coffee )?table");
    }
//-----------------------------------------------------------------------------
    @Override public String getSearchDialog() {
        Furniture g = Player.getPos().getFurnRef(GHOST_ID);
        
        if (g != null && ((Drar_Ghost)g).firstTime())
            return "You comb the table's surface. You do realize there's a ghost "
                    + "in here, correct? Probably integral to the game's progression...";
        
        return this.searchDialog;
    }
//-----------------------------------------------------------------------------
}
