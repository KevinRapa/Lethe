package Servants_Hall;

import A_Main.AudioPlayer;
import A_Main.Id;
import static A_Main.NameConstants.HAND_TORCH;
import A_Main.Player;
import static A_Main.NameConstants.WEAPON;
import static A_Main.NameConstants.WOOD_LOG;
import A_Super.Furniture;
import A_Super.Item;
import A_Super.Direction;
import A_Super.Door;

public class Sha1_Door extends Door {
    private final Item RAM_REF, BRKNRAM_REF;
    private final Furniture GEN_DR;
/* CONSTRUCTOR ---------------------------------------------------------------*/        
    public Sha1_Door(Item ram, Item brRam, Furniture genDr) {
        super(Direction.WEST);
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
    }
/*----------------------------------------------------------------------------*/
    @Override public String useEvent(Item item) {
        if (item.equals(RAM_REF)) {
            AudioPlayer.playEffect(40);
            Player.getRoomObj(Id.SHA1).addAdjacent(Id.SHAR); // Make SHAR accessible.
            Player.getRoomObj(Id.SHA1).removeFurniture(this); // Remove this door from the room.
            Player.getRoomObj(Id.SHA1).removeFurniture(GEN_DR);
            Player.getInv().remove(RAM_REF); // Take ram from player.
            Player.getInv().add(BRKNRAM_REF); // Add broken ram to player.
            return this.useDialog;        
        }
        else if (item.toString().equals(WOOD_LOG)) {
            return "What appears to be a battering ram is missing anything "
                 + "with which to hold. You can't obtain a firm enough grip.";
        }
        else if (item.getType().equals(WEAPON)) {
            AudioPlayer.playEffect(40);
            return "While a worthwile attempt, the door is build a bit too "
                 + "solidly to be knocked down with that.";
        }
        else if (item.toString().equals(HAND_TORCH)) {
            return "Unfortunately, the door is coated in what could only "
                 + "be recognized (by you at least) as fire-proof varnish.";
        }
        else
            return DEFAULT_USE;
    }
/*----------------------------------------------------------------------------*/
    @Override public String interact(String key) {
        if (key.matches("open|use|walk|go|close"))
            return this.actDialog;
        else {
            return super.interact(key);
        }
    } 
/*----------------------------------------------------------------------------*/
}

