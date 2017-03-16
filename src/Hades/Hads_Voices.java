package Hades;

import A_Super.Furniture;
/**
 * @author Kevin Rapa
 */
public class Hads_Voices extends Furniture {
    // ========================================================================
    public Hads_Voices () {
        super();
        
        this.description = actDialog = searchDialog = "You can't do even that.";
        this.addActKeys(ANYTHING);
        
        this.addNameKeys("(?:thousands of )?(?:lamenting )?voices?");
    }
    // ========================================================================      
}


