package A_Super;

import static A_Main.Names.*;
/**
 * @author Kevin Rapa
 */
public class Ceiling extends Furniture implements Unmoveable {
    // ========================================================================
    public Ceiling () {
        super();

        this.description = "There's nothing too exciting about the ceiling here.";
        this.actDialog = "It's too high up to do that. Also, why?";
        this.searchDialog = "Why would there be anything hidden in the ceiling?";
        this.useDialog = "You poke the ceiling with the long object.";

        this.addNameKeys("ceiling", "roof");
        this.addUseKeys(POLEARM, "wooden spear", "silver spear");
        this.addActKeys(FEELPATTERN);
    }
    // ======================================================================== 
}


