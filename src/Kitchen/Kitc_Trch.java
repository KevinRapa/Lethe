package Kitchen;

import Super.Trch;
import Super.Item;
import Core.Inventory;
import Super.Room;

public class Kitc_Trch extends Trch {
    private final Kitc REF3;
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Kitc_Trch(String NAME, Item trch, Inventory inv, Room kitc) {
        super(NAME, trch, inv);
        this.useDialog = "You slide the torch into the steel holder, lighting\n"
                       + "the room.";
        this.hasTorch = false;
        this.REF3 = (Kitc)kitc;
    }
/*----------------------------------------------------------------------------*/
    @Override public String interact(Room[][][] map, String key) {
        String rep = this.interactDialog;
        
        if (this.hasTorch) {
            this.hasTorch = false;
            REF2.add(REF);
            this.REF3.swtch();
        }
        else
            rep = "The holder is empty you bumbling oaf.";
        
        return rep;
    }
/*----------------------------------------------------------------------------*/  
    @Override public String useEvent(Item item) {
        String rep = this.useDialog;
        
        if (this.hasTorch)
            rep = "The holder already bears a torch you bumbling oaf.";
        
        else {
            this.hasTorch = true;
            this.REF3.swtch();
        }
        
        return rep;
    }
/*----------------------------------------------------------------------------*/
}

