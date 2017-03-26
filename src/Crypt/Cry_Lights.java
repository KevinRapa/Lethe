package Crypt;

import A_Super.Furniture;
/**
 * @author Kevin Rapa
 */
public class Cry_Lights extends Furniture {
    // ========================================================================
    public Cry_Lights () {
        super();

        this.description = "From the wall extend boney arms, palms up, holding "
                         + "small dishes. The surfaces of the dishes burn and give "
                         + "off the smell of brimstone.";
        this.actDialog = "You can't do that. They are attached to the wall.";

        this.addNameKeys("(?:boney )?arms", "(?:burning )?(?:platters?|dish(?:es)?)", 
                "torch(?:es)?", "protrusions?");
        this.addActKeys(GETPATTERN);
    }
    // ========================================================================     
}


