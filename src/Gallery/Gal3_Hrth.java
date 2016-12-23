package Gallery;

import A_Super.Fireplace;
import A_Super.Item;

public class Gal3_Hrth extends Fireplace {
     
/* CONSTRUCTOR ---------------------------------------------------------------*/        
    public Gal3_Hrth(boolean isLit, Item bckt) {       
        super(isLit, bckt);
        this.isLit = isLit;
        this.descLit = "The small lit hearth is made of a yellow plaster.";
        this.descUnlit = "A cold, unlit fireplace.";
    }
/*----------------------------------------------------------------------------*/
}
