package Oubliette;

import static A_Main.Names.FIXED_LADDER;
import static A_Main.Names.METAL_LADDER;
import A_Super.Furniture;
/**
 * Superficial. 
 * Links to Ou62 in the catacombs.
 * 
 * @see Oubliette.Ou62
 * @author Kevin Rapa
 */
public class Oub1_Pit extends Furniture {
    // ========================================================================
    public Oub1_Pit () {
        super();

        this.description = "You peer over the 8-foot wide pit. The pit empties "
                         + "into blackness. You cannot see the bottom. Though for "
                         + "a transient moment, a small glint catches your eye "
                         + "from an unknown distance down.";
        this.actDialog = "Probably nothing good will come of that.";
        this.useDialog = "The ladder is just too short for that...";

        this.addNameKeys("(?:8-foot wide )?(?:pit|hole)");
        this.addActKeys("jump", CLIMBPATTERN);
        this.addUseKeys(METAL_LADDER, FIXED_LADDER);
    }
    // ========================================================================      
}


