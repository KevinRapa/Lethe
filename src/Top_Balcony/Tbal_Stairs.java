package Top_Balcony;

import A_Main.AudioPlayer;
import A_Main.Id;
import A_Super.Direction;
import A_Super.Staircase;
/**
 * @author Kevin Rapa
 */
public class Tbal_Stairs extends Staircase {
    //-------------------------------------------------------------------------
    public Tbal_Stairs () {
        super(Direction.UP, Id.TBAL, 15);

        this.description = "The straight set of steps leads to a door giving "
                + "entrance to the solemn building to the north.";
    }
    //-------------------------------------------------------------------------   
    @Override public String interact(String key) { 
        AudioPlayer.playEffect(15);
        return "You slowly climb the set of steps.";
    }
    //-------------------------------------------------------------------------     
}


