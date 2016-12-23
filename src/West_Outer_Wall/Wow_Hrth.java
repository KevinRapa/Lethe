package West_Outer_Wall;

import A_Super.Fireplace;
import A_Super.Item;

public class Wow_Hrth extends Fireplace {
     
/* CONSTRUCTOR ---------------------------------------------------------------*/        
    public Wow_Hrth(boolean isLit, Item bckt) {       
        super(isLit, bckt);
        this.isLit = isLit;
        this.descLit = "A large arched hearth. The fire inside still burns. Hung\n"
                     + "in front of the hearth is a rack of towels and rags.";
        this.descUnlit = "A cold, unlit fireplace.";
    }
/*----------------------------------------------------------------------------*/
}
