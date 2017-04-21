package Cistern;

import A_Super.Room;
import A_Super.Direction;
/**
 * @author Kevin Rapa
 */
public class Cis5 extends Room {
//-----------------------------------------------------------------------------    
    public Cis5(String name, String ID) {
        super(name, ID);
    }
//-----------------------------------------------------------------------------
    @Override public String getBarrier(Direction dir) {
        return "There is water in all directions from here, extending into the black void.";
    }
//-----------------------------------------------------------------------------
}