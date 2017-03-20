package Garden;

import A_Main.AudioPlayer;
import static A_Main.NameConstants.*;
import A_Main.Player;
import A_Super.Item;
import A_Super.SearchableFurniture;
import A_Super.Unmoveable;
/**
 * @author Kevin Rapa
 */
public class Gar13_Planter extends SearchableFurniture implements Unmoveable {
    private final Item SOIL_REF;
    // ========================================================================
    public Gar13_Planter (Item soil, Item... items) {
        super(items);
        
        this.SOIL_REF = soil;
        this.description = "The long planter extends along the length of the\n"
                         + "garden's western edge. In it are a variety of plants\n"
                         + "which have seemingly flourished over the years.";
        this.actDialog = "You're a lumberjack, not a gardener!";
        this.searchDialog = "You fan around the plants in the planter.";
        this.useDialog = "You uncover nothing, but you do store a bit of soil in your pockets.";

        this.addNameKeys("planter|bed|plants|dirt", "(?:bed of )?(?:soil|dirt)", SOIL);
        this.addUseKeys(HOE, TROWEL, SHOVEL, SEED, FERTILIZER);
        this.addActKeys(GETPATTERN);
        this.addActKeys("garden", "plant", "dig", "shovel");
    }
    // ========================================================================     
    @Override public String useEvent(Item item) {
        if (item.toString().matches("trowel|shovel")) {
            AudioPlayer.playEffect(34);
            
            if (Player.getInv().add(SOIL_REF))
                return this.useDialog;
            else
                return NOTHING;
        }
        else 
            return this.actDialog;
    }
    // ========================================================================     
    @Override public String interact(String key) {
        if (key.equals("garden") || key.equals("plant")) {
            return this.actDialog;
        }
        else {
            if (Player.hasItem(TROWEL) || Player.hasItem(SHOVEL))
                return useEvent(new Item(SHOVEL, 0)); // Dummy item
            else
                return "You have nothing to dig with.";
        }
    }
    // ========================================================================     
}


