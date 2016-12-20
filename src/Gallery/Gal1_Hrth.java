package Gallery;

import Super.Fireplace;
import Super.Item;
import Main.Inventory;

public class Gal1_Hrth extends Fireplace {
     
/* CONSTRUCTOR ---------------------------------------------------------------*/        
    public Gal1_Hrth(boolean isLit, Item bckt, Inventory inv) {       
        super(isLit, bckt, inv);
        this.isLit = isLit;
        this.descLit = "The small hearth is tiled green and purple like the rest\n"
                     + "of the room. It's lit and it crackles.";
        this.descUnlit = "A cold, unlit fireplace.";
    }
/*----------------------------------------------------------------------------*/
}