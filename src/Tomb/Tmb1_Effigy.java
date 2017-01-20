package Tomb;

import A_Super.WallArt;
/**
 * @author Kevin Rapa
 */
public class Tmb1_Effigy extends WallArt {

    // ========================================================================
    public Tmb1_Effigy () {
        this.description = "It is a goat or pig skull tied to some criss-crossed\n"
                         + "bundles of dried grass. It's held together by a wooden frame.\n"
                         + "You aren't able to tell if this is a memorial or effigy...";

        this.addNameKeys("(?:unsettling )?(?:effigy|idol|totem)");
    }
    // ========================================================================  
}


