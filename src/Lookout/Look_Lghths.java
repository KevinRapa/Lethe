package Lookout;

import A_Super.Furniture;

public class Look_Lghths extends Furniture{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Look_Lghths() {
        super();
        this.searchable = false;
        this.description = "A classic red and white striped lighthouse. Its\n"
                         + "beacon illuminates northwards. You wish it would\n"
                         + "maybe spot you.";
        this.searchDialog = "The lighthouse is absolutely too far away to do that.";
        this.addNameKeys("(?:classic )?(?:red and white )?(?:striped )?lighthouse");
    }
/*----------------------------------------------------------------------------*/
}