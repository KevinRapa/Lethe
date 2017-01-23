package A_Super;

import A_Main.AudioPlayer;
import static A_Main.NameConstants.*;
import A_Main.Player;

/**
 * Represents the floor or ground in a room.
 * Superficial, though items may be stored here if needed.
 * 
 * @author Kevin Rapa
 */
public class Floor extends SearchableFurniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/        
    public Floor(String dsc, Item... items) {
            super(items);
            this.description = dsc;
            this.searchDialog = "You crouch down and scan the ground.";
            this.actDialog = "That's solid floor! Why would you think to do that?";
            this.useDialog = "There's no reason to stand the ladder up in here.";
            this.addActKeys("dig", "shovel");
            this.addUseKeys(FIXED_LADDER, SHOVEL, TROWEL);
            this.addNameKeys("floor", "ground", "walkway");
    }
/*----------------------------------------------------------------------------*/
    @Override public String interact(String key) {              
        if (Player.hasItem(SHOVEL) || Player.hasItem(TROWEL)) {
            return this.useEvent(new Item(SHOVEL));
        }
        else
            return "You have nothing with which to dig.";
    }
/*----------------------------------------------------------------------------*/ 
    @Override public String useEvent(Item item) {
        if (item.toString().equals(FIXED_LADDER))
            return this.useDialog;
        else {
            AudioPlayer.playEffect(35);
            return this.actDialog;
        }
    }
/*----------------------------------------------------------------------------*/
}
