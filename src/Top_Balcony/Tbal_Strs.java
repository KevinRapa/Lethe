package Top_Balcony;

import A_Super.Direction;
import A_Super.Staircase;
/**
 * @author Kevin Rapa
 */
public class Tbal_Strs extends Staircase {
    // ========================================================================
    public Tbal_Strs () {
        super(Direction.UP);

        this.description = "The straight set of steps leads to a door\n"
                         + "giving entrace to the solemn building to the\n"
                         + "north.";
    }
    // ========================================================================   
    @Override public String interact(String key) { 
        playEffect();
        return "You slowly climb the set of steps.";
    }
    // ========================================================================     
}


