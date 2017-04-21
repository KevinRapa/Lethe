package Laboratory;

import A_Super.Furniture;
/**
 * @author Kevin Rapa
 */
public class Labo_Hose extends Furniture {
    //-------------------------------------------------------------------------
    public Labo_Hose () {
        super();

        this.description = "The yellow rubber hose connects the gas pipe to the bunsen burner.";

        this.addNameKeys("(?:yellow )?(?:rubber )?hose");
    }
    //------------------------------------------------------------------------- 
}


