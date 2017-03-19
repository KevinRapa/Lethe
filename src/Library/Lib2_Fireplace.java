package Library;

import A_Super.Fireplace;
import A_Super.Item;

public class Lib2_Fireplace extends Fireplace {
/* CONSTRUCTOR ---------------------------------------------------------------*/        
    public Lib2_Fireplace(Item bckt) {       
        super(bckt);

        this.descLit = "The roaring fire from the large granite fireplace casts\n"
                     + "flickering shadows over the whole room. Like in the\n"
                     + "vestibule, you see a protrusion in the back. You guess\n"
                     + "fireplaces make good places to hide buttons. There's a\n"
                     + "small puddle of water in front of the fireplace.";
        
        this.descUnlit = descUnlit.concat(" There's a small button in the back.");
        
        this.searchDialogUnlit = "You can't see much but ash. There looks to be a\n"
                               + "small button in the back though.";
    }
/*----------------------------------------------------------------------------*/
}
