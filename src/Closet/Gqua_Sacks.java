package Closet;

import static A_Main.Names.HAND_DRILL;
import static A_Main.Names.WEAPON;
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
        
        this.actDialog = "The sacks are much too heavy to lift up.";
        this.description = "Three large white cloth sacks sit carelessly tossed "
                         + "against the wall. They have names of various gardening "
                         + "materials on them.";
        
        this.searchDialog = "You look into each of the sacks.";
        
        this.addUseKeys(ANYTHING);
        this.addActKeys(GETPATTERN);
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
