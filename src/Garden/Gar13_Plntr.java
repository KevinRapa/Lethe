package Garden;

import A_Main.Player;
import A_Super.Furniture;
import A_Super.Item;
/**
 * @author Kevin Rapa
 */
public class Gar13_Plntr extends Furniture {
    private final Item SOIL_REF;
    // ========================================================================
    public Gar13_Plntr (Item soil, Item... items) {
        super(items);
        
        this.SOIL_REF = soil;
        this.description = "The long planter extends along the length of the\n"
                         + "garden's western edge. In it are a variety of plants\n"
                         + "which have seemingly flourished over the years.";
        this.actDialog = "You're a lumberjack, not a gardener!";
        this.searchDialog = "You fan around the plants in the planter.";
        this.useDialog = "You uncover nothing, but you do store a bit of soil in your pockets.";

        this.addNameKeys("planter", "bed of soil", "soil", "bed", "plants");
        this.addUseKeys("hoe", "trowel", "shovel", "seed", "fertilizer");
        this.addActKeys("garden", "plant");
    }
    // ========================================================================     
    @Override public String useEvent(Item item) {
        if (item.toString().matches("trowel|shovel")) {
            if (Player.hasItem("soil"))
                return "You dig around a bit, but uncover nothing.";
            else {
                Player.getInv().add(SOIL_REF);
                return this.useDialog;
            }
        }
        else return this.actDialog;
    }
    // ========================================================================     
}


