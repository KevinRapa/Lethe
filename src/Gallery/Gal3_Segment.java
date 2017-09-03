package Gallery;

import A_Main.Id;
import A_Main.Player;
import A_Super.Furniture;

public class Gal3_Segment extends Furniture{
    private final int GAL3_TTM_ID;
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gal3_Segment(Furniture gal3Ttm) {
        super();
        this.GAL3_TTM_ID = gal3Ttm.getID();
        this.searchDialog = "The segments aren't hiding any items. You "
                          + "notice a seam between each.";
        this.description = "The faces on each segment are surreal and spooky. "
                         + "Seams separate the four of them slightly.";
        this.addActKeys(VALVEPATTERN, "pull", "move");
        this.addNameKeys("segments?");
    }
//-----------------------------------------------------------------------------
    @Override public String interact(String key) {
        return Player.getRoomObj(Id.GAL3).getFurnRef(GAL3_TTM_ID).interact(key);
    }
//-----------------------------------------------------------------------------
}
