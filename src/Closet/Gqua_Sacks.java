package Closet;

import A_Super.Item;
import A_Super.Openable;
import A_Super.SearchableFurniture;
/**
 * Contains fertilizer, a required item.
 * 
 * @see Parlor.Par1_EnchtTbl
 * @author Kevin Rapa
 */
public class Gqua_Sacks extends SearchableFurniture implements Openable {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gqua_Sacks(Item ... items) {
        super(items);
        this.description = "Three large white cloth sacks sit carelessly tossed\n"
                         + "against the wall. They have names of various gardening\n"
                         + "material on them.";
        this.searchDialog = "You look into each of the sacks.";
        this.addNameKeys("sacks?");
    }
/*----------------------------------------------------------------------------*/
}
