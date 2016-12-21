package Parlor;

import Super.Door;
import Super.Item;
import Main.Player;

public class Par1_Dr extends Door {
    private final Item REF3;
    private boolean cured = false;
/*----------------------------------------------------------------------------*/    
    public Par1_Dr(Item enchbttl) {
        super();
        this.useDialog = "You throw the fire on the door. Shortly, the fire"
                       + "\nfades away.";
        this.description = "It looks like a heavy wooden door.";
        
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
            Player.getMapRef()[3][2][4].addAdjacent("BHA3");
            rep = "You cast the fire onto the door, to which it clings\n"
                + "rapidly. The fire begins to fade away along with the\n"
                + "barrier.";
            this.cured = true;
        }
        Player.getINV().remove(item);
        Player.getINV().add(REF3);
        
        return rep;
    }
/*----------------------------------------------------------------------------*/ 
}

