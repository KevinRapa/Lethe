package Gallery;

import Core.Inventory;
import Super.Item;
import Core.GUI;

public class Drgn_Inv extends Inventory{
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
        return false;
    }
/*----------------------------------------------------------------------------*/
    @Override public void remove(Item removeThis) {
        this.CONT.remove(removeThis);
        GUI.out(REF.triggerEvent());
    }
/*----------------------------------------------------------------------------*/
    @Override public void give(Item item, Inventory giveToThis) {
        // Exchanges an item between two inventories.
        if (giveToThis.add(item)) {
            this.remove(item);
        }
        else
            GUI.out("The " + item + " doesn't fit in.");
        
    }
/*----------------------------------------------------------------------------*/
    private void triggerAdd(Item item) {
        if (item.toString().matches("(?:red|yellow|blue|dark) focus"))    
            GUI.out(REF.triggerEvent());
    }
/*----------------------------------------------------------------------------*/
}
