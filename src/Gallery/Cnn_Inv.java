package Gallery;

import Core.Inventory;
import Super.Item;
import Core.GUI;

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
        return false;
    }
/*----------------------------------------------------------------------------*/
    @Override public void remove(Item removeThis) {
        this.CONT.remove(removeThis);
        GUI.out(REF.triggerEvent(removeThis.toString()));
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
        if (item.toString().matches("(?:red|yellow|blue|dark) focus") || 
            item.toString().matches("box thingy"))    
            GUI.out(REF.triggerEvent(item.toString()));
    }
/*----------------------------------------------------------------------------*/
}

