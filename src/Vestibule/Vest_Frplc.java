package Vestibule;

import Super.Fireplace;
import Super.Item;

public class Vest_Frplc extends Fireplace {
     
/* CONSTRUCTOR ---------------------------------------------------------------*/        
    public Vest_Frplc(boolean isLit, Item bckt) {       
        super(isLit, bckt);
        this.isLit = isLit;
        this.descLit = "A roaring fireplace. It engulfs the room with a\n" +
                       "warm, flickering glow. Looking more closely, you\n" +
                       "notice an odd protrusion in the back.";
        this.descUnlit = "A cold, unlit fireplace. It looks like" +
                         " there's \na small Button in the back.";
        this.searchDialogUnlit = "You can't see much but ash. There looks to be a\n"
                               + "small button in the back though.";
    }
/*----------------------------------------------------------------------------*/
}
