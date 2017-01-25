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
        this.description = "So many times thus far you have felt so close to\n"
                         + "the outside of this castle. The thought taunts you.\n"
                         + "You feel as though days have passed, but it's been\n"
                         + "just a few hours.";

        this.addNameKeys("vents?", "moonlight");
    }
    // ======================================================================== 
}


