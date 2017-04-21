package Attic;

import A_Super.Ceiling;
/**
 * @author Kevin Rapa
 */
public class Att_Ceiling extends Ceiling {
    //-------------------------------------------------------------------------
    public Att_Ceiling () {
        super();
        
        this.description = "The ceiling here is just the underside of a gabled "
                         + "roof, reinforced with many gray wooden slats.";

        this.addNameKeys("(?:gray )?(?:wooden )?slats", "gabled roof", "sloped ceiling");
    }
    //-------------------------------------------------------------------------     
}


