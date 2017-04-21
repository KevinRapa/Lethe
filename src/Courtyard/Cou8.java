package Courtyard;

import A_Super.Room;
import A_Super.Direction;
/**
 * @author Kevin Rapa
 */
public class Cou8 extends Room {
//-----------------------------------------------------------------------------    
    public Cou8(String name, String ID) {
        super(name, ID);
    }
//-----------------------------------------------------------------------------
    @Override public String getBarrier(Direction dir) {
        return "Be careful! You don't want to fall out!";
    }
//-----------------------------------------------------------------------------
}