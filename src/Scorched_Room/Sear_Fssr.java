package Scorched_Room;

import Super.Item;
import Super.Room;
import Main.Inventory;
import Super.Furniture;

public class Sear_Fssr extends Furniture {
    private final Room REF;
    private final Inventory REF2;
    private final Item REF3;
    
    public Sear_Fssr(Room sear, Inventory inv, Item gift) {
        super();
        this.searchable = false;
        this.REF = sear;
        this.REF2 = inv;
        this.REF3 = gift;
        this.searchDialog = "It's just an empty hole.";
        this.description = "The fissure leads outside into the front\n"
                         + "courtyard. It looks like this was part of\n"
                         + "the escape plan.";
        this.useDialog = "The wall gives way from the swing of the heavy\n"
                       + "warhammer, but the warhammer snaps in half. You\n"
                       + "begin to think the wood axe is the only tool\n"
                       + "you know how to use without it breaking.";
        this.addNameKeys("fissure");
        this.addUseKeys("warhammer", "crowbar", "hammer");
    }
    
/*----------------------------------------------------------------------------*/
    @Override public String useEvent(Item item) {
        String rep = this.useDialog;
        
        if (item.toString().matches("warhammer")) {            
            REF.addAdjacent("COU2");
            REF2.remove(item);
            REF2.add(REF3);
        }
        else if (item.toString().matches("hammer")) {
            rep = "You give it a swing, but this hammer is too\n"
                + "small to break this wall. They must've been\n"
                + "using something else.";
        }
        else if (item.toString().matches("crowbar")) {
            rep = "You give the crowbar a swing, but it just\n"
                + "rebounds with a loud *THWANG*. They must've\n"
                + "been hitting with something else";
        }       
        return rep;
    }
/*----------------------------------------------------------------------------*/    
    @Override public String getDescription() {
        String rep = this.description;
        
        if (REF.isThisLocked()) {
            rep = "The hole leads outside.";
        }              
        return rep; 
    }
/*----------------------------------------------------------------------------*/
}
