package Kitchen;

import Super.Fireplace;
import Super.Item;
import Main.Inventory;

// DEVELOP THIS LATER, FUTURE PUZZLE.

public class Kitc_Hrth extends Fireplace {

/* CONSTRUCTOR ---------------------------------------------------------------*/     
    public Kitc_Hrth(Inventory plyrInv, Item bckt) {
        super(false, bckt, plyrInv);
        this.searchable = false;   
        this.descLit = "";
        this.descUnlit = "";
        this.searchDialogUnlit = "";
    }
/*----------------------------------------------------------------------------*/
}

