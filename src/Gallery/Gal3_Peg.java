package Gallery;

import A_Main.Id;
import A_Main.Player;
import A_Super.Furniture;

public class Gal3_Peg extends Furniture {
    private final int GAL3_TTM_ID;
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gal3_Peg(Furniture gal3Ttm) {
        super();
        this.GAL3_TTM_ID = gal3Ttm.getID();
        this.description = "The pegs stick out the sides of each segment. "
                         + "Interesting- there is a seam between each segment.";
        this.addActKeys("turn", MOVEPATTERN);
        this.addNameKeys("pegs?");
    }
//-----------------------------------------------------------------------------
    @Override public String interact(String key) {
        return Player.getRoomObj(Id.GAL3).getFurnRef(GAL3_TTM_ID).interact(key);
    }
//-----------------------------------------------------------------------------
}
