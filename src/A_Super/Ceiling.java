package A_Super;

import static A_Main.NameConstants.*;
/**
 * @author Kevin Rapa
 */
public class Ceiling extends Furniture {
    // ========================================================================
    public Ceiling () {
        super();

        this.actDialog = "It's too high up to do that. Also, why?";
        this.searchDialog = "Why would there be anything hidden in the ceiling?";
        this.useDialog = "You poke the ceiling with the long object.";

        this.addUseKeys(POLEARM, "wooden spear", "silver spear");
        this.addActKeys(FEELPATTERN);
    }
    // ======================================================================== 
}


