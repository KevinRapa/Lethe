package Servants_Hall;

import Super.Furniture;
import Super.Item;
import Main.Player;

public class Sha1_Dr extends Furniture {
    private final Item REF3;
    private final Item REF4;
/* CONSTRUCTOR ---------------------------------------------------------------*/        
    public Sha1_Dr (Item ram, Item brRam) {
        super();
        this.REF3 = ram;
        this.REF4 = brRam;
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
        Player.getMapRef()[3][5][2].addAdjacent("SHAR"); // Make SHAR accessible.
        Player.getMapRef()[3][5][2].removeFurniture(this); // Remove this door from the room.
        Player.getINV().remove(REF3); // Take ram from player.
        Player.getINV().add(REF4); // Add broken ram to player.
        
        return this.useDialog;
/*----------------------------------------------------------------------------*/        
    }
}

