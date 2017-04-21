package Hades;

import A_Super.Furniture;
/**
 * @author Kevin Rapa
 */
public class Hads_Spirits extends Furniture {
    //-------------------------------------------------------------------------
    public Hads_Spirits () {
        super();;
        
        this.description = actDialog = searchDialog = "You can't do even that.";
        this.addActKeys(ANYTHING);

        this.addNameKeys("(?:evil )?(?:jeering )?spirits");
    }
    //------------------------------------------------------------------------- 
}


