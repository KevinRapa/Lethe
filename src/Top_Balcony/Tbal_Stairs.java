package Top_Balcony;

import A_Super.Direction;
import A_Super.Staircase;
/**
 * @author Kevin Rapa
 */
public class Tbal_Stairs extends Staircase {
    //-------------------------------------------------------------------------
    public Tbal_Stairs () {
        super(Direction.UP);

        this.description = "The straight set of steps leads to a door "
                         + "giving entrance to the solemn building to the "
                         + "north.";
    }
    //-------------------------------------------------------------------------   
    @Override public String interact(String key) { 
        playEffect();
        return "You slowly climb the set of steps.";
    }
    //-------------------------------------------------------------------------     
}


