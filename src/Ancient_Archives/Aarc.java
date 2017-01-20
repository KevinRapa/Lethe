package Ancient_Archives;

import A_Main.Player;
import static A_Main.NameConstants.HAND_TORCH;
import A_Super.Room;
/**
 * Contains a key to the Keepers chamber and a note hinting where the Factum is.
 * 
 * @see Ancient_Archives.Aarc_Note
 * @see Keeper_Chamber.Dkch
 * @author Kevin Rapa
 */
public class Aarc extends Room {
// ============================================================================    
    public Aarc(String name, String ID) {
        super(name, ID);
        this.description= "The torch lights the room just enough to see. The room\n"
                        + "is in ruins and smells of algae. The floor has warped with the\n" +
                          "underlying soil over time and has partially collapsed\n" +
                          "into a sinkhole. You stand near the west wall on a\n" +
                          "slightly raised stone platform overlooking many books\n" +
                          "and piles of wood littering the floor. An unlit iron\n" +
                          "chandelier hangs from the ceiling.";
    }
// ============================================================================
    @Override public String getDescription() {
        return Player.hasItem(HAND_TORCH) ? this.description :
                "You are in a pitch black room. You can't sense a thing but the\n"
              + "smell of wilt.";
    }
// ============================================================================
}