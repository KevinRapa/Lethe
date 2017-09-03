package Tunnels;

import A_Main.GUI;
import A_Main.Id;
import A_Main.Inventory;
import A_Main.Player;
import A_Super.Furniture;
import A_Super.Item;
/**
 * Items may be added to this, but because of the current, all items added
 * to this will be diverted to Sew1_Rvr.
 * 
 * @see Tunnels.Sew1_Rvr
 * @author Kevin Rapa
 */
public class Sew2345_River extends Sewer_River {
    //-------------------------------------------------------------------------
    public Sew2345_River (Furniture sew1Rvr, Item wtr) {
        super(wtr);
        
        this.inv = new River_Inventory(sew1Rvr);
        
        this.description = "The river is about 11 feet across and 5 feet deep. " +
                           "It flows through an artificial square channel " +
                           "constructed into the floor. The water looks clear " +
                           "and smells quite clean. You imagine that it was " +
                           "a natural stream at some point before being built " +
                           "around. The river flows down the tunnel " +
                           "eastwards with quite a strong current. ";
    }
    //-------------------------------------------------------------------------
    private class River_Inventory extends Inventory {
        private final int SEW1_RVR_ID;
        // --------------------------------------------------------------------
        public River_Inventory(Furniture sew1Inv) {
            super();
            this.SEW1_RVR_ID = sew1Inv.getID();
        }
        // --------------------------------------------------------------------
        @Override public boolean add(Item item) {
            GUI.out("You drop the item in. It immediately is whisked away down "
                  + "the river.");
            Player.getRoomObj(Id.SEW1).getFurnRef(SEW1_RVR_ID)
                    .getInv().forceAdd(item);
            return true;
        }
    }
}


