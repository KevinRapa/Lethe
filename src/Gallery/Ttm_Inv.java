package Gallery;

import A_Main.Inventory;
import A_Super.Item;
import A_Main.GUI;

public class Ttm_Inv extends Inventory{
    private final Gal3_Ttm REF;    
// CONSTRUCTOR -----------------------------------------------------------------      
    public Ttm_Inv(Gal3_Ttm ttm, Item ... items) {
        super(items);
        this.REF = ttm;
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
