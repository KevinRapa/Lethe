package Observatory;

import A_Main.NameConstants;
import A_Super.Item;

public class Obs_Plate extends Item {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Obs_Plate (String name, String desc) {
        super(name, desc);
        this.type = NameConstants.PLATE;
    }
/*----------------------------------------------------------------------------*/    
}