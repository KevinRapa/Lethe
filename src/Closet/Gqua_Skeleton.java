package Closet;

import static A_Main.NameConstants.CROWBAR;
import A_Super.Item;
import A_Super.SearchableFurniture;
/**
 * Contains a crowbar, a required item.
 * 
 * @see Ransacked_Quarters.Rqua_Pnl
 * @author Kevin Rapa
 */
public class Gqua_Skeleton extends SearchableFurniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gqua_Skeleton(Item... items) {
        super(items);
        this.description = "The body lies face down on the floor.";
        this.searchDialog = "You crouch down.";
        this.addNameKeys("skeleton");
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
