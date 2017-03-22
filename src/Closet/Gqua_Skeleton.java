package Closet;

import static A_Main.Names.CROWBAR;
import A_Super.Item;
import A_Super.Skeleton;
/**
 * Contains a crowbar, a required item.
 * 
 * @see Ransacked_Quarters.Rqua_Pnl
 * @author Kevin Rapa
 */
public class Gqua_Skeleton extends Skeleton {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gqua_Skeleton(Item... items) {
        super(items);
        this.description = "The body lies face down on the floor.";
    }
/*----------------------------------------------------------------------------*/
    @Override public String getDescription() {
        if (this.containsItem(CROWBAR)) 
            return this.description.concat(" There's a crowbar in its hand.");
        else
            return this.description;
    }
/*----------------------------------------------------------------------------*/
}
