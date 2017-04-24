package Crypt;

import A_Main.Id;
import A_Main.Player;
import A_Super.Room;
/**
 * @author Kevin Rapa
 */
public class Cry2 extends Room {
//-----------------------------------------------------------------------------    
    public Cry2(String name, String ID) {
        super(name, ID);
    }
//-----------------------------------------------------------------------------
    @Override public String getDescription() {
        if (Player.getPos().isAdjacent(Id.CAS1)) {
            return super.getDescription().replaceFirst(
                    "Standing against the west wall is a tall stone coffin with an engraving on the wall framing it.", 
                    "To the west is a metal door framed by an engraving. The stone coffin stands next to it."
            );
        }
        return super.getDescription();
    }
//-----------------------------------------------------------------------------
}