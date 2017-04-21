package Hades;

import A_Super.Furniture;
/**
 * @author Kevin Rapa
 */
public class Hads_Gateway extends Furniture {
    //-------------------------------------------------------------------------
    public Hads_Gateway () {
        super();
        
        this.description = actDialog = searchDialog = "You can't do even that.";
        this.addActKeys(ANYTHING);
        this.addNameKeys("(?:large )?(?:open )?gate(?:way)?");
    }
    //-------------------------------------------------------------------------            
}


