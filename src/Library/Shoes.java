package Library;

import A_Main.ItemTypeConstants;
import A_Super.Item;
import A_Main.Player;

public class Shoes extends Item {
/* CONSTRUCTOR ---------------------------------------------------------------*/  
    public Shoes (String name, String desc, String use) {
        super(name, desc, use);
        this.type = ItemTypeConstants.SHOES;
    }
/*----------------------------------------------------------------------------*/
    @Override public String useEvent() {
        if (! Player.getShoes().matches(this.NAME)) {
            Player.setShoes(this.NAME);
        }
        else {
            Player.setShoes("");
            return "You remove them and put your old shoes back on.";
        }
        return this.useDialog;
    }
/*----------------------------------------------------------------------------*/
}
