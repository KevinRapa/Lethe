package Closet;

import A_Super.Ceiling;

public class Gqua_Ceiling extends Ceiling {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gqua_Ceiling() {
        super();

        this.description = "It's a low arched cobblestone ceiling supported\n"
                         + "by a few parallel wood trusses.";
        this.addNameKeys("(?:low )?(?:arched )?(?:cobblestone )?ceiling", 
                         "(?:parallel )?(?:wooden )?truss(?:es)?");
    }
/*----------------------------------------------------------------------------*/
}
