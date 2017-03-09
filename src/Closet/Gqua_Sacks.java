package Closet;

import static A_Main.NameConstants.HAND_DRILL;
import static A_Main.NameConstants.WEAPON;
import A_Super.Item;
import A_Super.Moveable;
import A_Super.Openable;
import A_Super.SearchableFurniture;
/**
 * Contains fertilizer, a required item.
 * 
 * @see Parlor.Par1_EnchtTbl
 * @author Kevin Rapa
 */
public class Gqua_Sacks extends SearchableFurniture implements Openable, Moveable {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gqua_Sacks(Item ... items) {
        super(items);
        this.description = "Three large white cloth sacks sit carelessly tossed\n"
                         + "against the wall. They have names of various gardening\n"
                         + "material on them.";
        
        this.searchDialog = "You look into each of the sacks.";
        
        this.addUseKeys(ANYTHING);
        this.addNameKeys("(?:large )?(?:white )?(?:cloth )?sacks?");
    }
/*----------------------------------------------------------------------------*/
    @Override public String useEvent(Item item) {
        if (item.getType().equals(WEAPON) || item.toString().equals(HAND_DRILL))
            return "Don't be so reckless!";
        else
            return DEFAULT_USE;
    }
/*----------------------------------------------------------------------------*/
}
