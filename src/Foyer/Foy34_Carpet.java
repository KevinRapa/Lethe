package Foyer;

import A_Super.Carpet;
/**
 * @author Kevin Rapa
 */
public class Foy34_Carpet extends Carpet {
    //-------------------------------------------------------------------------
    public Foy34_Carpet () {
        super();
        
        this.description = "The thick red carpet runner follows up and down "
                         + "the foyer staircase.";

        this.addNameKeys("(?:thick )?(?:red )?(?:carpet|rug)(?: runner)?");
    }
    //------------------------------------------------------------------------- 
}


