package Gallery;

import A_Main.Inventory;
import A_Super.Item;
import A_Main.GUI;

public class Drgn_Inv extends Inventory {
    private final Gal1_Drgn REF;    
// CONSTRUCTOR -----------------------------------------------------------------      
    public Drgn_Inv(Gal1_Drgn drgn, Item ... items) {
        super(items);
        this.REF = drgn;
    }
/*----------------------------------------------------------------------------*/
    @Override public boolean add(Item item) { 
        if (item.getType().matches("focus")) {
            this.CONT.add(item);
            this.triggerAdd(item);
            return true;
        }
        GUI.out("The " + item + " doesn't fit in.");
        return false;
    }
/*----------------------------------------------------------------------------*/
    @Override public void remove(Item removeThis) {
        this.CONT.remove(removeThis);
        GUI.out(REF.triggerEvent());
    }
/*----------------------------------------------------------------------------*/
    private void triggerAdd(Item item) {
        if (item.toString().matches("(?:red|yellow|blue|dark) focus"))    
            GUI.out(REF.triggerEvent());
    }
/*----------------------------------------------------------------------------*/
}
