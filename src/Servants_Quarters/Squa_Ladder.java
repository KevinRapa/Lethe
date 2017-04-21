package Servants_Quarters;

import A_Super.Item;

public class Squa_Ladder extends Item {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Squa_Ladder(String name, Item forms, int thresh) {
        super(name, forms, thresh, 0);
        this.useID = 1;
        this.useDialog = "This ladder has a couple rungs missing, and your "
                       + "short legs can't handle the gap.";
        this.description = "A fifteen foot folding ladder. Two of its rungs "
                         + "are missing.";
    }    
//-----------------------------------------------------------------------------
}
