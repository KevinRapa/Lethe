package Crypt;

import A_Main.Id;
import A_Main.Player;
import A_Super.Room;
/**
 * @author Kevin Rapa
 */
public class Cry2 extends Room {
// ============================================================================    
    public Cry2(String name, String ID) {
        super(name, ID);
        this.description= "You stand at the north end of the chamber. Arranged in a \n" +
                          "grid pattern on the east wall are numerous drawers with \n" +
                          "knobs on each. Protrusions from the walls resembling \n" +
                          "boney arms hold up burning platters serving as torches.\n" +
                          "Standing against the west wall is a tall stone coffin " +
                          "with an engraving on the wall framing it. At the north\n" +
                          "wall is an altar.";
    }
// ============================================================================
    @Override public String getDescription() {
        if (Player.getPos().isAdjacent(Id.CAS1)) {
            return this.description.replaceFirst(
                    "Standing against the west wall is a tall stone coffin with an engraving on the wall framing it", 
                    "To the west is a metal door framed by an engraving. The stone coffin stands next to it."
            );
        }
        return this.description;
    }
// ============================================================================
}