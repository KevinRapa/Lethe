package Observatory;

import A_Main.Inventory;
import A_Super.Item;

public class Slt_Inv extends Inventory{
    private final Obs_Slts REF;
    
    public Slt_Inv(Obs_Slts slts, Item ... items) {
        super(items);
        this.REF = slts;
    }
/*----------------------------------------------------------------------------*/
    @Override public boolean add(Item item) {
        // Only accepts plate items.
        boolean success = true;
        
        if (item.getType().matches("plate")) {
            this.CONT.add(item);
            this.REF.checkSolved();
        }
        else
            success = false;

        return success;
    }
/*----------------------------------------------------------------------------*/
    @Override public void remove(Item removeThis) {
        // Taken variable ensures multiple items with same name aren't removed together.        
        this.CONT.remove(removeThis);
    }
/*----------------------------------------------------------------------------*/
    @Override public String toString() {
        // Returns a list of items in the inventory.
        String rep = "";
        int pos = 1;
                
        for (Item i : this.CONT) {
            String item = i.toString();
            String first = i.toString().substring(0, 1).toUpperCase();
            item = item.replaceFirst("^\\w", first);

            rep += ("<" + pos + "> " + item + " (" + this.REF.getSlots()[pos - 1].getDescription() + ")\n"); 
            
            pos++;
        }
        return rep;
    }
/*----------------------------------------------------------------------------*/
}
