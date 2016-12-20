package Gallery;

import Super.Fireplace;
import Super.Item;
import Main.Inventory;

public class Gal3_Hrth extends Fireplace {
     
/* CONSTRUCTOR ---------------------------------------------------------------*/        
    public Gal3_Hrth(boolean isLit, Item bckt, Inventory inv) {       
        super(isLit, bckt, inv);
        this.isLit = isLit;
        this.descLit = "The small lit hearth is made of a yellow plaster.";
        this.descUnlit = "A cold, unlit fireplace.";
    }
/*----------------------------------------------------------------------------*/
}
