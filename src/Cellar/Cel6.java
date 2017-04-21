package Cellar;

import A_Super.Room;
import A_Super.Direction;
/**
 * @author Kevin Rapa
 */
public class Cel6 extends Room {
//-----------------------------------------------------------------------------    
    public Cel6(String name, String ID) {
        super(name, ID);
    }
//-----------------------------------------------------------------------------
    @Override public String getBarrier(Direction dir) {
        return "There's nothing but a railing separating you from the black unknown.";
    }
//-----------------------------------------------------------------------------
}