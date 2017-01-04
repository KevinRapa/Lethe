package Parlor;

import A_Super.Door;
import A_Super.Item;
import A_Main.Player;
import A_Super.Direction;

public class Par1_Dr extends Door {
    private final Item ENCHNTBTTL_REF;
    private boolean cured = false;
/*----------------------------------------------------------------------------*/    
    public Par1_Dr(Item enchbttl, Direction dir) {
        super(dir);
        this.useDialog = "You throw the fire on the door. Shortly, the fire"
                       + "\nfades away.";
        this.description = "It looks like a heavy wooden door.";
        
        this.ENCHNTBTTL_REF = enchbttl;
        this.addUseKeys("sacred fire");
    }
/*----------------------------------------------------------------------------*/
    @Override public String getDescription() {
        if (! this.cured)
            return "The door has an odd pale-blue tint to it. As you approach,\n"
                 + "you feel a coldness. Upon closer inspection, you can see the\n"
                 + "blue tint pulsing.";
        
        return this.description;
    }
/*----------------------------------------------------------------------------*/ 
    @Override public String useEvent(Item item) {
        String rep = this.useDialog;
        
        if (! this.cured) {
            Player.getRoomRef("PAR1").addAdjacent("BHA3");
            rep = "You cast the fire onto the door, to which it clings\n"
                + "rapidly. The fire begins to fade away along with the\n"
                + "barrier.";
            this.cured = true;
        }
        Player.getInv().remove(item);
        Player.getInv().add(ENCHNTBTTL_REF);
        
        return rep;
    }
/*----------------------------------------------------------------------------*/ 
}

