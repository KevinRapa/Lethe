package Tunnels;

import A_Main.GUI;
import A_Main.Inventory;
import A_Super.Item;
/**
 * Items may be added to this, but because of the current, all items added
 * to this will be diverted to Sew1_Rvr.
 * 
 * @see Tunnels.Sew1_Rvr
 * @author Kevin Rapa
 */
public class Sew2345_Rvr extends Sewer_River {
    // ========================================================================
    public Sew2345_Rvr (Inventory sew1RvrInv, Item wtr) {
        super(wtr);
        
        this.inv = new River_Inventory(sew1RvrInv);
        
        this.description = "The river is about 11 feet across and 5 feet deep.\n" +
                           "It flows through an artificial square channel\n" +
                           "constructed into the floor. The water looks clear\n" +
                           "and smells quite clean. You imagine that it was\n" +
                           "a natural spring at some point before being built\n" +
                           "around. The river flows down the tunnel\n" +
                           "eastwards with quite a strong current. ";
    }
    // ========================================================================
    // ************************************************************************
    // ========================================================================
    private class River_Inventory extends Inventory {
        private final Inventory SEW1_RIVER_INV;
        // ====================================================================
        public River_Inventory(Inventory sew1Inv) {
            super();
            this.SEW1_RIVER_INV = sew1Inv;
        }
        // ====================================================================
        @Override public boolean add(Item item) {
            GUI.out("You drop the item in. It immediately is whisked away down\n"
                  + "the river.");
            SEW1_RIVER_INV.contents().add(item);
            return true;
        }
        // ====================================================================    
    }
    // ========================================================================
    // ************************************************************************
    // ========================================================================
}


