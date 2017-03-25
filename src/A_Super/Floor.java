package A_Super;

import A_Main.AudioPlayer;
import static A_Main.Names.*;
import A_Main.Player;

/**
 * Represents the floor or ground in a room.
 * Superficial, though items may be stored here if needed.
 * 
 * @author Kevin Rapa
 */
public class Floor extends SearchableFurniture implements Unmoveable {
/* CONSTRUCTOR ---------------------------------------------------------------*/        
    public Floor(String dsc, Item... items) {
            super(items);
            this.description = dsc;
            this.searchDialog = "You crouch down and scan the ground.";
            this.actDialog = "You jam the spade into the floor. Your body jolts and you stagger back. Why would you think to do that?";
            this.useDialog = "There's no reason to stand the ladder up in here.";
            this.addActKeys("dig", SHOVEL, MOP, "clean");
            this.addUseKeys(FIXED_LADDER, SHOVEL, TROWEL, MOP, "sweep");
            this.addNameKeys("floor", "ground", "walkway");
    }
/*----------------------------------------------------------------------------*/
    @Override public String interact(String key) {     
        if (key.equals("clean"))
            return "Oh yes, you're sure the owner of this castle would love that.";
        else if (key.equals(MOP) || key.equals("sweep")) {
            if (Player.hasItem(MOP))
                return this.useEvent(new Item(MOP, 0)); // Dummy item
            else
                return "You have nothing mop the floor with. "
                     + "Do you really want to do that anyway? "
                     + "One less thing you need is a slippery floor.";
        }
        else {
            if (Player.hasItem(SHOVEL) || Player.hasItem(TROWEL))
                return this.useEvent(new Item(SHOVEL, 0));
            else
                return "You have nothing with which to dig.";
        }
    }
/*----------------------------------------------------------------------------*/ 
    @Override public String useEvent(Item item) {
        if (item.toString().equals(FIXED_LADDER)) // Dummy item
            return this.useDialog;
        else if (item.toString().equals(MOP))
            return "Yes, let's just make this a game about cleaning some madman's castle.";
        else {
            AudioPlayer.playEffect(35);
            return this.actDialog;
        }
    }
/*----------------------------------------------------------------------------*/
}
