package Library;

import Super.Item;
import Main.Player;

public class Shoes extends Item {
    private final Player REF;
/* CONSTRUCTOR ---------------------------------------------------------------*/  
    public Shoes (String name, String desc, String use, Player plyr) {
        super(name, desc, use);
        this.REF = plyr;
        this.type = "shoes";
    }
/*----------------------------------------------------------------------------*/
    @Override public String useEvent() {
        String rep = this.useDialog;
        
        if (! REF.shoes().matches(this.NAME)) {
            REF.switchShoes(this.NAME);
        }
        else {
            rep = "You remove them and put your old shoes back on.";
            REF.switchShoes("");
        }

        return rep;
    }
/*----------------------------------------------------------------------------*/
}
