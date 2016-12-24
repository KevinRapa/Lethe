package Observatory;

import A_Main.GUI;
import A_Main.Inventory;
import A_Super.Item;

public class Slt_Inv extends Inventory{
    
    public Slt_Inv(Item ... items) {
        super(items);
    }
/*----------------------------------------------------------------------------*/
    @Override public boolean add(Item item) {
        if (item.getType().matches("plate") && this.size() == 0) {
            this.CONT.add(item);
            return true;
        }
        
        GUI.out("There's already a plate in here.");
        return false;
    }
/*----------------------------------------------------------------------------*/
}
