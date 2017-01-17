package Tomb;

import A_Super.Wall_Art;
/**
 * @author Kevin Rapa
 */
public class Tmb3_Tpstry extends Wall_Art {

    // ========================================================================
    public Tmb3_Tpstry () {
        super();
        this.description = "The tapestry is mainly just superficial designs,\n"
                         + "though woven in the center is a hexagram inside\n"
                         + "of a circle.";

        this.addNameKeys("(?:small )?(?:hanging )?(?:torn |ripped )?tapestry");
    }
    // ========================================================================   
}


