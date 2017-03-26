package Black_Staircase;

import A_Super.StaticWndw;
/**
 * @author Kevin Rapa
 */
public class Bls_Windows extends StaticWndw {
    // ========================================================================
    public Bls_Windows () {
        super();

        this.description = "The atrium is glassed in from floor to ceiling. To "
                         + "the west, you can see the rooftop garden from which "
                         + "you escaped the parlor. To the north, you see a terminal "
                         + "room higher up in the castle supported by a large pillar. "
                         + "The moon begins to fade and a small amount of light brightens "
                         + "the sky.";

        this.addNameKeys("ceiling|walls?|windows?|glass|moon|day");
    }
    // ========================================================================  
}


