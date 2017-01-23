package Servants_Quarters;

import A_Super.Furniture;
        
public class Squa_Candle extends Furniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Squa_Candle () {
        super();

        this.description = "A lit candle. The wax has hardly melted!";
        this.searchDialog = "It's just a candle...";
        this.actDialog = "Ouch! That's really hot!";
        this.addNameKeys("(?:lit )?(?:wax )?candle");
        this.addActKeys("grab", "hold", "touch");
    }
/*----------------------------------------------------------------------------*/
}