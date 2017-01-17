package Cell;

import static A_Main.NameConstants.HAND_TORCH;
import A_Super.Resetable;
import A_Super.Torch;
/**
 * @author Kevin Rapa
 */
public class Intr_Trch extends Torch implements Resetable {
    // ======================================================================== 
    @Override public void reset() {
        if (! this.containsItem(HAND_TORCH))
            this.inv.add(TORCH);
    }   
    // ======================================================================== 
}


