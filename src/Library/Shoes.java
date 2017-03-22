package Library;

import A_Main.Names;
import A_Main.Player;
import A_Super.Clothing;

public class Shoes extends Clothing {
/* CONSTRUCTOR ---------------------------------------------------------------*/  
    public Shoes (String name, String desc, String use, int score) {
        super(name, desc, use, score);
        this.type = Names.SHOES;
    }
/*----------------------------------------------------------------------------*/
    @Override public String useEvent() {
        if (! Player.getShoes().equals(NAME)) {
            Player.setShoes(NAME);
        }
        else {
            Player.setShoes("");
            return "You remove them and put your old shoes back on.";
        }
        return this.useDialog;
    }
/*----------------------------------------------------------------------------*/
}
