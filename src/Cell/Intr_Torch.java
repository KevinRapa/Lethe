package Cell;

import static A_Main.Names.HAND_TORCH;
import A_Super.Resetable;
import A_Super.Torch_Holder;
/**
 * @author Kevin Rapa
 */
public class Intr_Torch extends Torch_Holder implements Resetable {
    // ======================================================================== 
    @Override public void reset() {
        if (! this.containsItem(HAND_TORCH))
            this.inv.add(TORCH);
    }   
    // ======================================================================== 
}


