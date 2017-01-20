package Observatory;

import A_Super.Furniture;
/**
 * @author Kevin Rapa
 */
public class Obs3_Telescopes extends Furniture {
    // ========================================================================
    public Obs3_Telescopes () {
        super();
        this.searchable = false;
        
        this.description = "The telescopes have many different copper parts and\n"
                         + "intricate carvings. One of them is pointed at the\n"
                         + "lighthouse along the cliff in the distance.";
        this.actDialog = "You gaze through the telescope pointed at the lighthouse.\n"
                       + "As the beacon rotates in your direction, the blinding glare\n"
                       + "forces your eye away.";
        this.searchDialog = "They look like just plain telescopes. Expensive though.";

        this.addNameKeys("telescopes?");
        this.addActKeys("use", "look", "gaze", "view");
    }
    // ========================================================================   
}


