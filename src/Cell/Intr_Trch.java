package Cell;

import A_Super.Resetable;
import A_Super.Torch;
/**
 * @author Kevin Rapa
 */
public class Intr_Trch extends Torch implements Resetable {
    // ======================================================================== 
    @Override public void reset() {
        if (! this.doesThisHaveIt("hand torch"))
            this.inv.add(TORCH);
    }   
    // ======================================================================== 
}


