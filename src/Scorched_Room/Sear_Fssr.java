package Scorched_Room;

import A_Main.Player;
import A_Super.Item;
import A_Super.Furniture;

public class Sear_Fssr extends Furniture {
    private final Item BRKNWRHMMR_REF;
    
    public Sear_Fssr(Item gift) {
        super();
        this.searchable = false;
        this.BRKNWRHMMR_REF = gift;
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
            Player.getMapRef()[3][6][4].addAdjacent("COU2");
            Player.getInv().remove(item);
            Player.getInv().add(BRKNWRHMMR_REF);
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
        
        if (Player.getMapRef()[3][6][4].isThisLocked()) {
            rep = "The hole leads outside. It's big enough to fit through.";
        }              
        return rep; 
    }
/*----------------------------------------------------------------------------*/
}
