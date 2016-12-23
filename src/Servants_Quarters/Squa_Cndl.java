package Servants_Quarters;

import A_Super.Furniture;
        
public class Squa_Cndl extends Furniture {

/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Squa_Cndl () {
        super();
        this.searchable = false;
        this.description = "A lit candle. The wax has hardly melted!";
        this.searchDialog = "It's just a candle...";
        this.actDialog = "Ouch! That's really hot!";
        this.addNameKeys("lit candle", "candle");
        this.addActKeys("grab", "hold", "touch");
    }
/*----------------------------------------------------------------------------*/
}