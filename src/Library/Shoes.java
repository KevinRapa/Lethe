package Library;

import Super.Item;
import Main.Player;

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
            Player.switchShoes(this.NAME);
        }
        else {
            rep = "You remove them and put your old shoes back on.";
            Player.switchShoes("");
        }

        return rep;
    }
/*----------------------------------------------------------------------------*/
}
