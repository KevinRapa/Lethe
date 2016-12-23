package Gallery;

import A_Main.Inventory;
import A_Super.Item;
import A_Main.GUI;

public class Cnn_Inv extends Inventory{
    private final Gal6_Cnn REF;    
// CONSTRUCTOR -----------------------------------------------------------------      
    public Cnn_Inv(Gal6_Cnn cnn, Item ... items) {
        super(items);
        this.REF = cnn;
    }
/*----------------------------------------------------------------------------*/
    @Override public boolean add(Item item) {   
        if (item.getType().matches("focus") || 
            item.toString().matches("box thingy")) {
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
        GUI.out(REF.triggerEvent(removeThis.toString()));
    }
/*----------------------------------------------------------------------------*/
    private void triggerAdd(Item item) {
        if (item.toString().matches("(?:red|yellow|blue|dark) focus") || 
            item.toString().matches("box thingy"))    
            GUI.out(REF.triggerEvent(item.toString()));
    }
/*----------------------------------------------------------------------------*/
}

