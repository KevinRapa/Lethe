package Kitchen;

import A_Super.Item;

public class Kitc_FrtPhy extends Item {
    
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Kitc_FrtPhy(String name, int score) {
        super(name, score);
        this.type = "phylactery";
        this.description = "This red, clean, shiny apple looks perfect! Huh... "
                         + "It has almost a glow to it.";
    }
/*----------------------------------------------------------------------------*/  
}  
