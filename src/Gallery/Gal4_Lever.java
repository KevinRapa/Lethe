package Gallery;

import A_Super.Lever;
/**
 * @author Kevin Rapa
 */
public class Gal4_Lever extends Lever {
/*----------------------------------------------------------------------------*/
    public Gal4_Lever () {
        super();
        
        this.description = "The small lever protrudes from the side of the tall "
                         + "radio. It appears to be an on switch.";
        this.actDialog = "Pulling the lever on the side appears to do nothing. The "
                       + "radio is evidently broken and is for show only.";

        this.addNameKeys("(?:small )?lever");
    }
/*----------------------------------------------------------------------------*/
    @Override protected String event(String key) {
        return this.actDialog;
    }
/*----------------------------------------------------------------------------*/   
}


