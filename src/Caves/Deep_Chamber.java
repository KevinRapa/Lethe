package Caves;
/**
 * This room distorts all descriptive output.
 * The player must take the magic artifact from this room, having prior knowledge
 * that the artifact is in here.
 * 
 * @author Kevin Rapa
 */
import A_Main.AudioPlayer;
import A_Super.Room;
import A_Super.Direction;

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
        AudioPlayer.playEffect(6);
        return Cave.distortDescription(2, "There is a wall in the way");
    }
// ============================================================================
    @Override public String getDescription() {
        return Cave.distortDescription(1, this.description);
    }
// ============================================================================
}