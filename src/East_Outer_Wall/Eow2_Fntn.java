package East_Outer_Wall;

import A_Super.Furniture;
/**
 * Superficial, but justifies the presence of water in the room for filling the metal bucket.
 * 
 * @see Library.Lib2
 * @see Library.Lib4
 * @author Kevin Rapa
 */
public class Eow2_Fntn extends Furniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/     
    public Eow2_Fntn() {
        super();
        this.searchable = false;
        this.description = "The fountain is running smoothly with clear water.\n"
                         + "In its center is a tall statue of a helmed woman\n"
                         + "holding a staff and shield. It reminds you of the\n"
                         + "soldier statue in the ruined courtyard fountain.\n"
                         + "Now that you think about it, it's the same fountain.";
        this.searchDialog = "You find a bunch of water, but you can't pocket that.";
        this.actDialog = "Now is NOT the time for a swim, though it's tempting. You\n"
                       + "don't even have a change of clothes, and you aren't wearing\n"
                       + "servant's garb.";
        this.addActKeys("jump", "swim");
        this.addNameKeys("(?:great )?fountain", "(?:soldier )?statue");
    }
/*----------------------------------------------------------------------------*/
}
