package Observatory;

import A_Main.ItemTypeConstants;
import A_Super.Item;

public class Obs_Plt extends Item {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Obs_Plt (String name, String desc) {
        super(name, desc);
        this.type = ItemTypeConstants.PLATE;
    }
/*----------------------------------------------------------------------------*/    
}