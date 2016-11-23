package Courtyard;

import Super.Furniture;

public class Cou3_Ivy extends Furniture{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Cou3_Ivy(String NAME) {
        super(NAME);
        this.searchable = false;
        this.description = "European ivy grows rampantly over everything.";
        this.searchDialog = "It's just plain old Hedera helix.";
        this.interactDialog = "It's no use ripping this off; it will just grow back.";
        this.addActKeys("grab", "hold", "touch");
        this.addNameKeys("ivy");
    }
/*----------------------------------------------------------------------------*/
}
