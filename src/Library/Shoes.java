package Library;

import A_Super.Item;
import A_Main.Player;

public class Shoes extends Item {
/* CONSTRUCTOR ---------------------------------------------------------------*/  
    public Shoes (String name, String desc, String use) {
        super(name, desc, use);
        this.type = "shoes";
    }
/*----------------------------------------------------------------------------*/
    @Override public String useEvent() {
        String rep = this.useDialog;
        
        if (! Player.getShoes().matches(this.NAME)) {
            Player.setShoes(this.NAME);
        }
        else {
            rep = "You remove them and put your old shoes back on.";
            Player.setShoes("");
        }

        return rep;
    }
/*----------------------------------------------------------------------------*/
}
