package Observatory;

import A_Super.Furniture;
import A_Super.Moveable;
/**
 * @author Kevin Rapa
 */
public class Obs3_Telescopes extends Furniture implements Moveable {
    //-------------------------------------------------------------------------
    public Obs3_Telescopes () {
        super();

        this.description = "The telescopes have many different copper parts and "
                         + "intricate carvings. One of them is pointed at the "
                         + "lighthouse along the cliff in the distance.";
        this.actDialog = "You gaze through the telescope pointed at the lighthouse. "
                       + "As the beacon rotates in your direction, the blinding glare "
                       + "forces your eye away.";
        this.searchDialog = "They look like just plain telescopes. Expensive though.";

        this.addNameKeys("telescopes?");
        this.addActKeys("use", "look", "gaze", "view");
    }
    //-------------------------------------------------------------------------   
}


