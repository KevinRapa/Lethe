package Courtyard;

import A_Super.Room;
import A_Super.Direction;
/**
 * @author Kevin Rapa
 */
public class Cou8 extends Room {
// ============================================================================    
    public Cou8(String name, String ID) {
        super(name, ID);
        this.description= "You stand on a firm branch about 12 feet up in the\n"
                        + "tree with your hand on the central trunk. There\n"
                        + "isn't much you can see up here, save for a raven's nest\n"
                        + "on one of the branches.";
    }
// ============================================================================
    @Override public String getBarrier(Direction dir) {
        return "Be careful! You don't want to fall out!";
    }
// ============================================================================
}