package Courtyard;

import A_Main.AudioPlayer;
import A_Main.Inventory;
import static A_Main.NameConstants.*;
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
        this.useDialog = this.actDialog;

        this.addNameKeys("dirt|earth", SOIL, GRASS, "weeds?|clovers?");
        this.addUseKeys(SHOVEL, TROWEL, HOE);
        this.addActKeys(GETPATTERN);
        this.addActKeys("dig", "shovel");
    }
    // ========================================================================   
    @Override public String interact(String key) {
        if (key.equals("dig") || key.equals("shovel")) {
            if (Player.hasItem(SHOVEL) || Player.hasItem(TROWEL)) {
                return this.useEvent(new Item(SHOVEL));
            }
            else
                return "You have nothing with which to dig.";
        }
        else
            return getIt();
    }
    // ========================================================================     
    @Override public String getIt() {
        Inventory i = Player.getInv();
        
        if (! (i.contains(SOIL_REF) && i.contains(GRASS_REF) && 
               i.contains(CLOVER_REF))) 
        {
            Player.getInv().add(SOIL_REF);
            Player.getInv().add(GRASS_REF);
            Player.getInv().add(CLOVER_REF);
            return "You jam your fingers into the ground and grab a fistful of Earth.";
        }
        else
            return "You already have some ground.";
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


