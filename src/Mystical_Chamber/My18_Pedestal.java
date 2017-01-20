package Mystical_Chamber;

import static A_Main.NameConstants.IRIDESCENT_JEWEL;
import A_Main.Player;
import A_Super.Direction;
import A_Super.Furniture;
import A_Super.Item;
/**
 * @author Kevin Rapa
 */
public class My18_Pedestal extends Furniture {
    private boolean hasStone;
    // ========================================================================
    public My18_Pedestal () {
        super();
        this.searchable = false;
        this.hasStone = false;
        this.description = "The pedestal has a round indentation in the center.";
        this.searchDialog = "There's nothing interesting about the pedestal.";

        this.addNameKeys("(?:sandstone )?pedestal");
        this.addUseKeys(IRIDESCENT_JEWEL);
    }
    // ======================================================================== 
    @Override public String getDescription() {
        return hasStone ? this.description : 
                "The iridescent stone sits flush into the indentation.";
    }
    // ========================================================================     
    @Override public String useEvent(Item item) {
        this.hasStone = true;
        Player.getPos().addFurniture(new My18_Stairs(Direction.DOWN));
        Player.getInv().remove(item);
        ((My18)Player.getPos()).updateDescription();
        
        return "The stone fits perfectly into the indentation. Immediately, the\n"
             + "ground begins to shake lightly. You step back. The seams in the floor\n"
             + "begin to cascase downward forming a spiral staircase descending\n"
             + "downwards into darkness.";
    }
    // ========================================================================     
}


