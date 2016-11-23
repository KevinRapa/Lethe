package Servants_Hall;

import Super.Furniture;
import Super.Item;
import Super.Room;
import Core.Inventory;

public class Sha1_Dr extends Furniture {
    private final Room REF2;
    private final Item REF3;
    private final Item REF4;
    private final Inventory REF5;
/* CONSTRUCTOR ---------------------------------------------------------------*/        
    public Sha1_Dr (String NAME, Room sha1, Item ram, Item brRam, Inventory inv) {
        super(NAME);
        this.REF2 = sha1;
        this.REF3 = ram;
        this.REF4 = brRam;
        this.REF5 = inv;
        this.description = "It's a small wooden door; a bit taller than you.\n"
                         + "The doorknob on it is missing.";
        this.interactDialog = "The doorknob is gone!!";
        this.useDialog = "You give the door a good bang with the ram. It gives\n"
                       + "from its hinges and falls to the floor. But the frayed\n"
                       + "rope you're holding the ram with snaps in half. Good\n"
                       + "thing that worked on the first try.";
        this.addActKeys("open", "use");
        this.addNameKeys("door");
        this.addUseKeys("battering ram");
    }
/*----------------------------------------------------------------------------*/
    @Override public String useEvent(Item item) {
        REF2.addAdjacent("RQUA"); // Make RQUA accessible.
        REF2.removeFurniture(this); // Remove this door from the room.
        REF5.remove(REF3); // Take ram from player.
        REF5.add(REF4); // Add broken ram to player.
        
        return this.useDialog;
/*----------------------------------------------------------------------------*/        
    }
}

