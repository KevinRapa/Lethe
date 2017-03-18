package Kampe_Quarters;

import A_Main.Inventory;
import A_Main.Player;
import A_Super.Item;
import java.util.Iterator;

/**
 * @author Kevin Rapa
 */
public class Kampe_Box extends Item {
    private final Inventory BOX_INV;
    private final Item EMPTY_BOX;
    //---------------------------------------------------------------------
    public Kampe_Box(Item ... items) {
        super("shoebox", "It resembles a large plain shoebox. Something rattles inside.", 
                "You remove as much as you can.", 5);
        
        this.EMPTY_BOX = new Item("empty shoebox", "The shoebox is now empty.", 5);

        this.BOX_INV = new Inventory(items);
    }
    //---------------------------------------------------------------------
    @Override public String useEvent() {
        Iterator<Item> iter = BOX_INV.iterator();
        
        while (iter.hasNext()) {
            Item i = iter.next();
            
            if (Player.getInv().add(i))
                iter.remove();
            else
                break;
        }
        
        if (! iter.hasNext()) {
            Player.getInv().remove(this);
            Player.getInv().add(EMPTY_BOX);
        }
        
        Player.printInv();
        
        return this.useDialog;
    }
    //---------------------------------------------------------------------
}
