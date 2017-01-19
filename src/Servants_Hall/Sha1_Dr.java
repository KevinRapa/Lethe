package Servants_Hall;

import A_Main.Id;
import static A_Main.NameConstants.BATTERING_RAM;
import A_Super.Furniture;
import A_Super.Item;
import A_Main.Player;

public class Sha1_Dr extends Furniture {
    private final Item RAM_REF, BRKNRAM_REF;
    private final Furniture GEN_DR;
/* CONSTRUCTOR ---------------------------------------------------------------*/        
    public Sha1_Dr(Item ram, Item brRam, Furniture genDr) {
        super();
        this.RAM_REF = ram;
        this.BRKNRAM_REF = brRam;
        this.GEN_DR = genDr;
        this.description = "It's a small wooden door; a bit taller than you.\n"
                         + "The doorknob on it is missing.";
        this.actDialog = "The doorknob is gone!!";
        this.useDialog = "You give the door a good bang with the ram. It gives\n"
                       + "from its hinges and falls to the floor. But the frayed\n"
                       + "rope you're holding the ram with snaps in half. Good\n"
                       + "thing that worked on the first try.";
        this.addActKeys("open", "use");
        this.addNameKeys("door", "west door");
        this.addUseKeys(BATTERING_RAM);
    }
/*----------------------------------------------------------------------------*/
    @Override public String useEvent(Item item) {
        Player.getRoomObj(Id.SHA1).addAdjacent(Id.SHAR); // Make SHAR accessible.
        Player.getRoomObj(Id.SHA1).removeFurniture(this); // Remove this door from the room.
        Player.getRoomObj(Id.SHA1).removeFurniture(GEN_DR);
        Player.getInv().remove(RAM_REF); // Take ram from player.
        Player.getInv().add(BRKNRAM_REF); // Add broken ram to player.
        
        return this.useDialog;        
    }
/*----------------------------------------------------------------------------*/
}

