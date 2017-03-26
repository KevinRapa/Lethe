package Ancient_Archives;

import A_Main.Player;
import static A_Main.Names.HAND_TORCH;
import A_Super.Room;
/**
 * Contains a key to the Keepers chamber and a note hinting where the Factum is.
 * Connects to Cis3
 * 
 * @see Cistern.Cis3
 * @see Ancient_Archives.Aarc_Note
 * @see Keeper_Chamber.Dkch
 * @author Kevin Rapa
 */
public class Aarc extends Room {
// ============================================================================    
    public Aarc(String name, String ID) {
        super(name, ID);
    }
// ============================================================================
    @Override public String getDescription() {
        return Player.hasItem(HAND_TORCH) ? this.description :
                "You are in a pitch black room. You can't sense a thing but the "
              + "smell of wilt and a wet floor.";
    }
// ============================================================================
}