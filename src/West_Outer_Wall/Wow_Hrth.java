package West_Outer_Wall;

import Super.Fireplace;
import Super.Item;
import Core.Inventory;

public class Wow_Hrth extends Fireplace {
     
/* CONSTRUCTOR ---------------------------------------------------------------*/        
    public Wow_Hrth(String NAME, boolean isLit, Item bckt, Inventory inv) {       
        super(NAME, isLit, bckt, inv);
        this.isLit = isLit;
        this.descLit = "A large arched hearth. The fire inside still burns. Hung\n"
                     + "in front of the hearth is a rack of towels and rags.";
        this.descUnlit = "A cold, unlit fireplace.";
    }
/*----------------------------------------------------------------------------*/
}
