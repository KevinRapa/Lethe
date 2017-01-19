package Kitchen;

import A_Main.GUI;
import A_Main.Id;
import A_Super.Torch;
import A_Super.Item;
import A_Main.Player;
import static A_Main.NameConstants.HAND_TORCH;
import A_Super.Hldr_Inv;
/**
 * Player must add a torch to this to light the room.
 * Begins empty.
 * @author Mantis Toboggan
 */
public class Kitc_Trch extends Torch {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Kitc_Trch() {
        super();
        this.useDialog = "You slide the torch into the steel holder, lighting\n"
                       + "the room.";
        this.inv = new KitcHldr_Inv();
    }
/*----------------------------------------------------------------------------*/
    @Override public String interact(String key) {
        String rep = this.actDialog;
        
        if (this.containsItem(HAND_TORCH)) {
            this.inv.give(TORCH, Player.getInv());
            ((Kitc)Player.getRoomObj(Id.KITC)).swtch();
        }
        else
            rep = "The holder is empty you bumbling oaf.";
        
        return rep;
    }
/*----------------------------------------------------------------------------*/  
    @Override public String useEvent(Item item) {
        String rep = this.useDialog;
        
        if (this.containsItem(HAND_TORCH))
            rep = "The holder already bears a torch you bumbling oaf.";
        
        else {
            Player.getInv().give(item, this.inv);
            ((Kitc)Player.getRoomObj(Id.KITC)).swtch();
        }
        
        return rep;
    }
/*----------------------------------------------------------------------------*/
    /**
     * When a torch is added to or taken from this, the kitchen light is switched.
     * @author Kevin Rapa
     */
    private class KitcHldr_Inv extends Hldr_Inv {
    // CONSTRUCTOR ------------------------------------------------------------     
        public KitcHldr_Inv() {
            super();
        }
    /*------------------------------------------------------------------------*/
        @Override public boolean add(Item item) { 
            if (item.toString().equals(HAND_TORCH) && this.size() == 0) {
                this.CONTENTS.add(item);
                ((Kitc)Player.getRoomObj(Id.KITC)).swtch();
                return true;
            }
            GUI.out("The " + item + " doesn't fit in.");
            return false;
        }
    /*------------------------------------------------------------------------*/
        @Override public void remove(Item item) {
            this.CONTENTS.remove(item);
            ((Kitc)Player.getRoomObj(Id.KITC)).swtch();
        }
    /*------------------------------------------------------------------------*/
    }
}

