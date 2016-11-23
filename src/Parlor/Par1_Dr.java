package Parlor;

import Super.Door;
import Super.Item;
import Core.Player;
import Super.Room;

public class Par1_Dr extends Door {
    private final Room REF;
    private final Player REF2;
    private final Item REF3;
    private boolean cured = false;
/*----------------------------------------------------------------------------*/    
    public Par1_Dr(String NAME, Room par1, Item enchbttl, Player plyr) {
        super(NAME);
        this.useDialog = "You throw the fire on the door. Shortly, the fire"
                       + "\nfades away.";
        this.description = "It looks like a heavy wooden door.";
        
        this.REF = par1;
        this.REF2 = plyr;
        this.REF3 = enchbttl;
        this.addUseKeys("sacred fire");
    }
/*----------------------------------------------------------------------------*/
    @Override public String getDescription() {
        String rep = this.description;
        
        if (! this.cured)
            rep = "The door has an odd pale-blue tint to it. As you approach,\n"
                + "you feel a coldness. Upon closer inspection, you can see the\n"
                + "blue tint pulsing.";
        
        return rep;
    }
/*----------------------------------------------------------------------------*/ 
    @Override public String useEvent(Item item) {
        String rep = this.useDialog;
        
        if (! this.cured) {
            this.REF.addAdjacent("BHA3");
            rep = "You cast the fire onto the door, to which it clings\n"
                + "rapidly. The fire begins to fade away along with the\n"
                + "barrier.";
            this.cured = true;
        }
        this.REF2.getINV().remove(item);
        this.REF2.getINV().add(REF3);
        
        return rep;
    }
/*----------------------------------------------------------------------------*/ 
}

