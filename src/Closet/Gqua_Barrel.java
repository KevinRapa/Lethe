package Closet;

import static A_Main.NameConstants.HAND_DRILL;
import static A_Main.NameConstants.WEAPON;
import A_Super.Furniture;
import A_Super.Item;
import A_Super.Openable;
/**
 * @author Kevin Rapa
 */
public class Gqua_Barrel extends Furniture implements Openable {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gqua_Barrel() {
        super();
        this.description = "It's a cask. You sure hope there's beer in there.";
        this.searchDialog = "You can't get it open. You take a whiff from a\n"
                          + "crack in its surface. Disgusting!!";
        
        this.actDialog = "This is way too heavy to move.";
        
        this.addUseKeys(ANYTHING);
        this.addNameKeys("barrel", "cask");
        this.addActKeys(MOVEPATTERN);
    }
/*----------------------------------------------------------------------------*/
    @Override public String useEvent(Item item) {
        if (item.getType().equals(WEAPON) || item.toString().equals(HAND_DRILL))
            return "Whatever nasty liquid is in there, you definitely don't want it seeping out all over the place.";
        else
            return DEFAULT_USE;
    }
/*----------------------------------------------------------------------------*/
}
