package Library;

import A_Main.NameConstants;
import A_Main.Player;
import A_Super.Clothing;

public class Shoes extends Clothing {
/* CONSTRUCTOR ---------------------------------------------------------------*/  
    public Shoes (String name, String desc, String use) {
        super(name, desc, use);
        this.type = NameConstants.SHOES;
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
