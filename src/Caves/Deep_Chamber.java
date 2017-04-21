package Caves;

import A_Super.Room;
import A_Super.Direction;
/**
 * This room distorts all descriptive output.
 * The player must take the magic factum from this room, having prior knowledge
 * that the factum is in here.
 * 
 * @see Caves.Factum_Dmmy
 * @author Kevin Rapa
 */
public class Deep_Chamber extends Room {
//-----------------------------------------------------------------------------    
    public Deep_Chamber(String name, String ID) {
        super(name, ID);
        this.description= "cat atnk tiouh intfgswrng zo apparently fin to "
                        + "lintt on top d qhtusk never ttho&ght that >os can't simply "
                        + "formnate pziPt4ty ligpt in the nse drtgitat a tiny "
                        + "dissont cataocmg dest i*ntr ahfo gor doo it rhiYe "
                        + "dew demgehZd4 bfrIxy move fin you bexore sd stokM off "
                        + "collab edify fire aelo aDasi.";
    }
//-----------------------------------------------------------------------------
    @Override public String getBarrier(Direction dir) {
        return Cave.distortDescription(2, bumpIntoWall());
    }
//-----------------------------------------------------------------------------
    @Override public String getDescription() {
        return Cave.distortDescription(1, this.description);
    }
//-----------------------------------------------------------------------------
    @Override public String triggeredEvent() {
        Cave.stopClip();
        
        return Cave.distortDescription(1, NAME);
    }
//-----------------------------------------------------------------------------
}