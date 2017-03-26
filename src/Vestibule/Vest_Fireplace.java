package Vestibule;

import A_Super.Fireplace;
import A_Super.Item;

public class Vest_Fireplace extends Fireplace {
     
/* CONSTRUCTOR ---------------------------------------------------------------*/        
    public Vest_Fireplace(Item bckt) {       
        super(bckt);

        this.descLit = "A roaring fireplace. It engulfs the room with a " +
                       "warm, flickering glow. Looking more closely, you " +
                       "notice an odd protrusion in the back.";
        
        this.descUnlit = descUnlit.concat(" It looks like there's a small button in the back.");
        
        this.searchDialogUnlit = "You can't see much but ash. There looks to be a "
                               + "small button in the back though.";
    }
/*----------------------------------------------------------------------------*/
}
