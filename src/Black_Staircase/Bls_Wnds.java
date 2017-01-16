package Black_Staircase;

import A_Super.Static_Wndw;
/**
 * @author Kevin Rapa
 */
public class Bls_Wnds extends Static_Wndw {
    // ========================================================================
    public Bls_Wnds () {
        super();
        this.searchable = false;
        
        this.description = "The atrium is glassed in from floor to ceiling. To\n"
                         + "the west, you can see the rooftop garden from which\n"
                         + "you escaped the parlor. To the north, you see a terminal\n"
                         + "room higher up in the castle supported by a large pillar.\n"
                         + "The moon begins to fade and a small amount of light brightens\n"
                         + "the sky.";

        this.addNameKeys("ceiling", "walls?", "windows", "glass", "moon", "day");
    }
    // ========================================================================  
}


