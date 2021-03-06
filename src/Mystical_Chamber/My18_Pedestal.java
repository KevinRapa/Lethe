package Mystical_Chamber;

import A_Main.AudioPlayer;
import A_Main.Id;
import static A_Main.Names.IRIDESCENT_JEWEL;
import A_Main.Player;
import A_Super.Direction;
import A_Super.Furniture;
import A_Super.Item;
import A_Super.Unmoveable;
/**
 * Adds furniture to its room if the iridescent jewel is used on this.
 * Iridescent jewel is somewhere in the catacombs- determined randomly.
 * Its location is written on a note in the Ancient Tomb in a casket.
 * 
 * @see Ancient_Tomb.Compass
 * @see Ancient_Tomb.Ant_Casket
 * @author Kevin Rapa
 */
public class My18_Pedestal extends Furniture implements Unmoveable {
    private boolean hasStone;
    private final Furniture STAIRS;
    //-------------------------------------------------------------------------
    public My18_Pedestal () {
        super();

        this.hasStone = false;
        this.description = "The pedestal has a globular indentation in the center.";
        this.searchDialog = "There's nothing interesting about the pedestal.";
        this.useDialog = "That doesn't fit in the indentation.";
        this.STAIRS = new My18_Stairs(Direction.DOWN, Id.CV18);
        
        this.addNameKeys("(?:sandstone )?pedestal");
        this.addUseKeys(ANYTHING);
    }
    //------------------------------------------------------------------------- 
    @Override public String getDescription() {
        return this.hasStone ? "The iridescent stone sits flush into the indentation." : 
                               this.description;
    }
    //-------------------------------------------------------------------------     
    @Override public String useEvent(Item item) {
        if (item.toString().equals(IRIDESCENT_JEWEL)) {
            this.hasStone = true;
            AudioPlayer.playEffect(37);
            Player.getPos().addFurniture(STAIRS);
            Player.getInv().remove(item);
            ((My18)Player.getPos()).updateDesc();

            return "The stone fits perfectly into the indentation. Immediately, the "
                 + "ground begins to shake lightly. You step back. The seams in the floor "
                 + "begin to cascade downward forming a spiral staircase descending "
                 + "downwards into darkness.";
        }
        else 
            return this.useDialog;
    }
    //-------------------------------------------------------------------------     
}


