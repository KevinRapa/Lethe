package Hades;

import static A_Main.Patterns.SEARCH_P;
import A_Main.Player;
import A_Super.Item;
import A_Super.SearchableFurniture;
/**
 * @author Kevin Rapa
 */
public class Hads_Corpses extends SearchableFurniture {
    //-------------------------------------------------------------------------
    public Hads_Corpses (Item... items) {
        super(items);
        
        this.description = actDialog = "You can't do even that.";
        this.searchDialog = "You fan through the pile of corpses.";
        this.addActKeys(ANYTHING);
        
        this.addNameKeys("(?:pile of )?(?:mangled )?(?:corpses?|bodies)");
    }
    //-------------------------------------------------------------------------
    @Override public String interact(String key) {
        if (SEARCH_P.matcher(key).matches()) {
            Player.trySearch(this);
            return NOTHING;
        }
        else
            return this.actDialog;
    }
    //-------------------------------------------------------------------------
}


