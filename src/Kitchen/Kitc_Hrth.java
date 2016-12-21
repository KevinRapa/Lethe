package Kitchen;

import Super.Fireplace;
import Super.Item;

// DEVELOP THIS LATER, FUTURE PUZZLE.

public class Kitc_Hrth extends Fireplace {

/* CONSTRUCTOR ---------------------------------------------------------------*/     
    public Kitc_Hrth(Item bckt) {
        super(false, bckt);
        this.searchable = false;   
        this.descLit = "";
        this.descUnlit = "";
        this.searchDialogUnlit = "";
    }
/*----------------------------------------------------------------------------*/
}

