package Servants_Quarters;

import A_Super.Item;

public class Squa_Ladder extends Item {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Squa_Ladder(String name, Item forms, int thresh) {
        super(name, forms, thresh);
        this.useID = 1;
        this.useDialog = "This ladder has a couple rungs missing, and your\n"
                       + "short legs can't handle the gap.";
        this.description = "A fifteen foot folding ladder. Two of its rungs\n"
                         + "are missing.";
    }    
/*----------------------------------------------------------------------------*/
}
