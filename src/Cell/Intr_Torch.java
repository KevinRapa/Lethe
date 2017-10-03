package Cell;

import A_Super.Item;
import A_Super.Resetable;
import A_Super.Torch_Holder;
/**
 * @author Kevin Rapa
 */
public class Intr_Torch extends Torch_Holder implements Resetable {
    public Intr_Torch(Item torch) {
        super(torch);
    }
    //------------------------------------------------------------------------- 
    @Override public void reset() {
        if (! this.inv.contains(TORCH.toString()))
            this.inv.add(TORCH);
    }   
    //------------------------------------------------------------------------- 
    @Override public String interact(String key) {
        if (key.equals("pull"))
            return "Nope, nothing. Of all the torches you wanted "
                    + "to be a disguised lever, this was the one.";
        else
            return super.interact(key);
    }
    //-------------------------------------------------------------------------
}


