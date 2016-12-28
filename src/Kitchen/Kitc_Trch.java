package Kitchen;

import A_Super.Trch;
import A_Super.Item;
import A_Main.Player;

public class Kitc_Trch extends Trch {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Kitc_Trch() {
        super();
        this.useDialog = "You slide the torch into the steel holder, lighting\n"
                       + "the room.";
        this.inv.remove(TORCH);
    }
/*----------------------------------------------------------------------------*/
    @Override public String interact(String key) {
        String rep = this.actDialog;
        
        if (this.doesThisHaveIt("hand torch")) {
            this.inv.give(TORCH, Player.getInv());
            ((Kitc)Player.getRoomRef("KITC")).swtch();
        }
        else
            rep = "The holder is empty you bumbling oaf.";
        
        return rep;
    }
/*----------------------------------------------------------------------------*/  
    @Override public String useEvent(Item item) {
        String rep = this.useDialog;
        
        if (this.doesThisHaveIt("hand torch"))
            rep = "The holder already bears a torch you bumbling oaf.";
        
        else {
            Player.getInv().give(item, this.inv);
            ((Kitc)Player.getRoomRef("KITC")).swtch();
        }
        
        return rep;
    }
/*----------------------------------------------------------------------------*/
}

