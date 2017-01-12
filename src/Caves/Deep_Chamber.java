package Caves;

import A_Super.Room;
import A_Super.Direction;
/**
 * This room distorts all descriptive output.
 * The player must take the magic artifact from this room, having prior knowledge
 * that the artifact is in here.
 * 
 * @see Caves.Magic_Artifact
 * @author Kevin Rapa
 */
public class Deep_Chamber extends Room {
// ============================================================================    
    public Deep_Chamber(String name, String ID) {
        super(name, ID);
        this.description= "cat atnk tiouh intfgswrng zo apparently fin to\n"
                        + "lintt on top d qhtusk never ttho&ght that >os can't simply\n"
                        + "formnate pziPt4ty ligpt in the nse drtgitat a tiny\n"
                        + "dissont cataocmg dest i*ntr ahfo gor doo it rhiYe\n"
                        + "dew demgehZd4 bfrIxy move fin you bexore sd stokM off\n"
                        + "collab edify fire aelo aDasi.";
    }
// ============================================================================
    @Override public String getBarrier(Direction dir) {
        return Cave.distortDescription(2, bumpIntoWall());
    }
// ============================================================================
    @Override public String getDescription() {
        return Cave.distortDescription(1, this.description);
    }
// ============================================================================
    @Override public String triggeredEvent() {
        return Cave.distortDescription(1, NAME);
    }
// ============================================================================
}