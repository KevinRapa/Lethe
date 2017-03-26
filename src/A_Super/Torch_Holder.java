package A_Super;

import A_Main.GUI;
import A_Main.Inventory;
import static A_Main.Names.HAND_TORCH;
import A_Main.Player;
/**
 * Represents a wall-mounted torch that can be taken.
 * Torches are useful for a few things.
 * 
 * @see Laboratory.Labo_Dstllr
 * @see Catacombs.Catacomb
 * @see Caves.Cave
 * @see Kitchen.Kitc_Trch
 * @author Kevin Rapa
 */
public class Torch_Holder extends SearchableFurniture {
    protected final Item TORCH;
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Torch_Holder(Item torch) {
        super();
        this.TORCH = torch;
        this.inv = new HolderInventory(torch);
        
        this.description = "Sitting in a steel holder is a burning wall torch "
                         + "giving off an orange glow.";
        this.searchDialog = "You look in the mounted steel holder.";
        this.actDialog = "You slide the torch out of its holder and take it.";
        this.useDialog = "You slide the torch into the steel holder.";
        
        this.addActKeys(GETPATTERN);
        this.addNameKeys("(?:wall )?torch(?:es)?", "(?:steel )?holders?");
        this.addUseKeys(HAND_TORCH);
    }
/*----------------------------------------------------------------------------*/
    @Override public String interact(String key) {
        if (this.inv.contains(TORCH)) {
            if (this.inv.give(TORCH, Player.getInv()))
                return this.actDialog;
            else
                return NOTHING;
        }
        else
            return "The holder is empty you bumbling oaf.";
    }
/*----------------------------------------------------------------------------*/  
    @Override public String useEvent(Item item) {
        if (this.inv.contains(TORCH))
            return "The holder already bears a torch you bumbling oaf.";
        else {
            Player.getInv().give(item, this.inv);
            return this.useDialog;
        }
    }
/*----------------------------------------------------------------------------*/
    @Override public String getDescription() {
        if (! this.containsItem(HAND_TORCH))
            return "The mounted steel holder is empty.";
        else    
            return this.description;
    }
/*----------------------------------------------------------------------------*/
    @Override public String getSearchDialog() {
        return this.getDescription();
    }
/*----------------------------------------------------------------------------*/
/******************************************************************************/    
/*----------------------------------------------------------------------------*/
    private class HolderInventory extends Inventory {  
    // CONSTRUCTOR -------------------------------------------------------------      
        public HolderInventory(Item ... items) {
            super(items);
        }
    /*------------------------------------------------------------------------*/
        @Override public boolean add(Item item) { 
            if (item.toString().equals(HAND_TORCH) && this.size() == 0) {
                this.CONTENTS.add(item);
                return true;
            }
            else {
                GUI.out("The " + item + " doesn't fit in.");
                return false;
            }
        }
    /*------------------------------------------------------------------------*/
    }
}