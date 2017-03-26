package Attic;

import A_Super.StaticWndw;
/**
 * @author Kevin Rapa
 */
public class Att_Vents extends StaticWndw {
    // ========================================================================
    public Att_Vents () {
        super();
        
        this.actDialog = "They're too high up to reach.";
        this.escapeDialog = "You couldn't possibly fit your huge body between those slats.";
        this.description = "So many times thus far you have felt so close to "
                         + "the outside of this castle. The thought taunts you. "
                         + "You feel as though days have passed, but it's been "
                         + "just a few hours.";

        this.addNameKeys("vents?", "moonlight");
    }
    // ======================================================================== 
}


