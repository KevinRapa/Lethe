package A_Super;
/**
 * This is a special inventory for mounted torch holders.
 * Only hand torches can be added to this, and this may only hold one hand torch.
 * @author Kevin Rapa
 */
import A_Main.Inventory;
import A_Main.GUI;

public class Hldr_Inv extends Inventory {  
// CONSTRUCTOR -----------------------------------------------------------------      
    public Hldr_Inv(Item ... items) {
        super(items);
    }
/*----------------------------------------------------------------------------*/
    @Override public boolean add(Item item) { 
        if (item.toString().matches("hand torch") && this.size() == 0) {
            this.CONTENTS.add(item);
            return true;
        }
        GUI.out("The " + item + " doesn't fit in.");
        return false;
    }
/*----------------------------------------------------------------------------*/
}
