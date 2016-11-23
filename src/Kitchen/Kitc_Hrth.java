package Kitchen;

import Super.Fireplace;
import Super.Item;
import Core.Inventory;

// DEVELOP THIS LATER, FUTURE PUZZLE.

public class Kitc_Hrth extends Fireplace {

/* CONSTRUCTOR ---------------------------------------------------------------*/     
    public Kitc_Hrth(String NAME, Inventory plyrInv, Item bckt) {
        super(NAME, false, bckt, plyrInv);
        this.searchable = false;   
        this.descLit = "";
        this.descUnlit = "";
        this.searchDialogUnlit = "";
    }
/*----------------------------------------------------------------------------*/
}

