package Cellar;

import A_Super.Column;
/**
 * @author Kevin Rapa
 */
public class Cel6_Columns extends Column {
    // ========================================================================
    public Cel6_Columns () {
        super();
        
        this.description = 
                "A couple huge, wide columns standing perhaps 40 feet "
                + "away are nearly blanketed by the darkness.";
        this.useDialog = actDialog = 
                searchDialog = "They are unreachable from here.";

        this.addNameKeys("(?:huge )?(?:distant )?(?:wide )?columns?");
    }
    // ======================================================================== 
}


