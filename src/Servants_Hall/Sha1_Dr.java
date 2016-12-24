package Servants_Hall;

import A_Super.Furniture;
import A_Super.Item;
import A_Main.Player;

public class Sha1_Dr extends Furniture {
    private final Item RAM_REF;
    private final Item BRKNRAM_REF;
/* CONSTRUCTOR ---------------------------------------------------------------*/        
    public Sha1_Dr (Item ram, Item brRam) {
        super();
        this.RAM_REF = ram;
        this.BRKNRAM_REF = brRam;
        this.description = "It's a small wooden door; a bit taller than you.\n"
                         + "The doorknob on it is missing.";
        this.actDialog = "The doorknob is gone!!";
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
        Player.getRoomRef("SHA1").addAdjacent("SHAR"); // Make SHAR accessible.
        Player.getRoomRef("SHA1").removeFurniture(this); // Remove this door from the room.
        Player.getInv().remove(RAM_REF); // Take ram from player.
        Player.getInv().add(BRKNRAM_REF); // Add broken ram to player.
        
        return this.useDialog;
/*----------------------------------------------------------------------------*/        
    }
}

