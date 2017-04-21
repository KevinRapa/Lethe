package Black_Staircase;

import A_Super.Item;
import A_Super.PottedPlant;
/**
 * @author Kevin Rapa
 */
public class Bls1_Plants extends PottedPlant {
    //-------------------------------------------------------------------------
    public Bls1_Plants (Item soil, Item gift) {
        super(soil, gift);

        this.description = "Many small potted plants, trees, and bushes decorate the "
                         + "atrium. They appear okay, but could afford a bit more care.";

        this.addNameKeys("plants?", "trees?", "bush(?:es)?");
    }
    //-------------------------------------------------------------------------     
}


