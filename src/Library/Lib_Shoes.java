package Library;

import Super.Item;

public class Lib_Shoes extends Item {
    private boolean beingWorn;
/* CONSTRUCTOR ---------------------------------------------------------------*/  
    public Lib_Shoes (String name, String desc, String use) {
        super(name, desc, use);
        this.beingWorn = false;
        this.type = "shoes";
    }
/*----------------------------------------------------------------------------*/
    @Override public String useEvent() {
        String rep = this.useDialog;
        
        if (this.beingWorn) {
            rep = "You remove the " + this.NAME + "\nand put your old shoes back on.";
            this.beingWorn = false;
        }
        else
            this.beingWorn = true;
        
        return rep;
    }
/*----------------------------------------------------------------------------*/
    public boolean isWorn() {
        return this.beingWorn;
    }
/*----------------------------------------------------------------------------*/
}
