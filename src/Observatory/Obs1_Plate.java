package Observatory;

import A_Main.Names;
import A_Super.Item;

public class Obs1_Plate extends Item {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Obs1_Plate (String name, String desc) {
        super(name, desc, 30);
        this.type = Names.PLATE;
    }
//-----------------------------------------------------------------------------    
}