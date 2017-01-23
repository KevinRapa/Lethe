package Courtyard;

import A_Main.AudioPlayer;
import static A_Main.NameConstants.*;
import A_Main.Player;
import A_Super.Floor;
import A_Super.Item;
/**
 * @author Kevin Rapa
 */
public class Cou_Floor extends Floor {
    // ========================================================================
    public Cou_Floor (Item... items) {
        super("The ground is a mixture of grass, weeds, and clover.", items);

        this.actDialog = "You dig a small hole in the ground, but find nothing of interest\n"
                       + "and kick the dirt back in the hole.";
        this.useDialog = this.actDialog;

        this.addUseKeys(SHOVEL, TROWEL);
        this.addActKeys("dig");
    }
    // ========================================================================   
    @Override public String interact(String key) {              
        if (Player.hasItem(SHOVEL) || Player.hasItem(TROWEL)) {
            return this.useEvent(new Item(SHOVEL));
        }
        else
            return "You have nothing with which to dig.";
    }
    // ========================================================================     
    @Override public String useEvent(Item item) {
        AudioPlayer.playEffect(34);
        return this.actDialog;
    }
    // ========================================================================     
}


