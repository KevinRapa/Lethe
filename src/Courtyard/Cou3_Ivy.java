package Courtyard;

import A_Super.Furniture;
/**
 * @author Kevin Rapa
 */
public class Cou3_Ivy extends Furniture{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Cou3_Ivy() {
        super();
        this.searchable = false;
        this.description = "European ivy grows rampantly over everything.";
        this.searchDialog = "It's just plain old Hedera helix.";
        this.actDialog = "It's no use ripping this off; it will just grow back.";
        this.addActKeys("grab", "hold", "touch");
        this.addNameKeys("(?:european )?ivy", "hedera helix");
    }
/*----------------------------------------------------------------------------*/
}
