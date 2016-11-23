package Lookout;

import Super.Furniture;

public class Look_Lghths extends Furniture{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Look_Lghths(String NAME) {
        super(NAME);
        this.searchable = false;
        this.description = "A classic red and white striped lighthouse. Its\n"
                         + "beacon illuminates northwards. You wish it would\n"
                         + "maybe spot you.";
        this.searchDialog = "The lighthouse is absolutely too far away to do that.";
        this.addNameKeys("lighthouse");
    }
/*----------------------------------------------------------------------------*/
}