package Courtyard;

import A_Main.AudioPlayer;
import A_Main.Inventory;
import static A_Main.Names.*;
import A_Main.Player;
import A_Super.Floor;
import A_Super.Gettable;
import A_Super.Item;
/**
 * @author Kevin Rapa
 */
public class Cou_Floor extends Floor implements Gettable {
    private final Item SOIL_REF, GRASS_REF, CLOVER_REF;
    // ========================================================================
    public Cou_Floor (Item soil, Item grass, Item clover, Item... items) {
        super("The ground is a mixture of grass, weeds, and clover.", items);

        this.SOIL_REF = soil;
        this.GRASS_REF = grass;
        this.CLOVER_REF = clover;
        
        this.actDialog = "You dig a small hole in the ground, but find nothing of interest\n"
                       + "and kick the dirt back in the hole.";
        this.useDialog = "You have nothing with which to dig.";

        this.addNameKeys("dirt|earth", SOIL, GRASS, "weeds?|clovers?");
        this.addUseKeys(SHOVEL, TROWEL, HOE);
        this.addActKeys(GETPATTERN, "dig", SHOVEL);
    }
    // ========================================================================   
    @Override public String interact(String key) {
        if (key.equals("dig") || key.equals(SHOVEL)) {
            if (Player.hasItem(SHOVEL) || Player.hasItem(TROWEL)) {
                return this.useEvent(new Item(SHOVEL, 0)); // Dummy item
            }
            else
                return this.useDialog;
        }
        else
            return getIt();
    }
    // ========================================================================     
    @Override public String getIt() {
        Inventory i = Player.getInv();
        
        if (i.add(SOIL_REF) && i.add(GRASS_REF) && i.add(CLOVER_REF)) 
            return "You jam your fingers into the ground and grab a fistful of Earth.";
        else
            return "You have full pockets.";
    }
    // ========================================================================     
    @Override public String useEvent(Item item) {
        if (item.toString().equals(HOE))
            return "You aren't a gardener!";
        else {
            AudioPlayer.playEffect(34);
            return this.actDialog;
        }
    }
    // ========================================================================     
}


