package Secret_Archives;

import Main.Inventory;
import Super.Item;

public class Art_Inv extends Inventory{
    private final Lib1_Art REF;    
    
    public Art_Inv(Lib1_Art art, Item ... items) {
        super(items);
        this.REF = art;
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
        REF.triggerEvent();
    }
/*----------------------------------------------------------------------------*/
    private void triggerAdd(Item item) {
        if (item.toString().matches("(?:red|yellow|blue|dark) focus"))       
            REF.triggerEvent();
    }
/*----------------------------------------------------------------------------*/
}
