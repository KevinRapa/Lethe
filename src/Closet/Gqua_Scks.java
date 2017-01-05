package Closet;

import A_Super.Container;
import A_Super.Furniture;
import A_Super.Item;

public class Gqua_Scks extends Furniture implements Container {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gqua_Scks(Item ... items) {
        super(items);
        this.description = "Three large white cloth sacks sit carelessly tossed\n"
                         + "against the wall. They have names of various gardening\n"
                         + "material on them.";
        this.searchDialog = "You look into each of the sacks.";
        this.addNameKeys("sacks?");
    }
/*----------------------------------------------------------------------------*/
}
