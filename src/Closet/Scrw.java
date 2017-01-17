package Closet;

import static A_Main.NameConstants.RED_FOCUS;
import A_Super.Item;

public class Scrw extends Item {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Scrw(String name, Item forms) {
        super(name, forms, RED_FOCUS, 3);
        this.description = "It's a tiny little screw.";
    }    
/*----------------------------------------------------------------------------*/  
}
