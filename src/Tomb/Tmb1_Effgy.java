package Tomb;

import A_Super.Wall_Art;
/**
 * @author Kevin Rapa
 */
public class Tmb1_Effgy extends Wall_Art {

    // ========================================================================
    public Tmb1_Effgy () {
        this.description = "It is a goat or pig skull tied to some criss-crossed\n"
                         + "bundles of dried grass. It's held together by a wooden frame.\n"
                         + "You aren't able to tell if this is a memorial or effigy...";

        this.addNameKeys("(?:unsettling )?(?:effigy|idol|totem)");
    }
    // ========================================================================  
}


