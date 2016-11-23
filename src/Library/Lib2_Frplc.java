package Library;

import Super.Fireplace;
import Super.Item;
import Core.Inventory;

public class Lib2_Frplc extends Fireplace {
     
/* CONSTRUCTOR ---------------------------------------------------------------*/        
    public Lib2_Frplc(String NAME, boolean isLit, Item bckt, Inventory inv) {       
        super(NAME, isLit, bckt, inv);
        this.isLit = isLit;
        this.descLit = "The roaring fire from the large granite fireplace casts\n"
                     + "flickering shadows over the whole room. Like in the\n"
                     + "vestibule, you see a protrusion in the back. You guess\n"
                     + "fireplaces make good places to hide buttons. There's a\n"
                     + "small puddle of water in front of the fireplace.";
        this.descUnlit = "A cold, unlit fireplace. There's a small button\n"
                       + "in the back.";
        this.searchDialogUnlit = "You can't see much but ash. There looks to be a\n"
                               + "small button in the back though.";
    }
/*----------------------------------------------------------------------------*/
}
