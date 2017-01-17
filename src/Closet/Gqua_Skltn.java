package Closet;

import static A_Main.NameConstants.CROWBAR;
import A_Super.Furniture;
import A_Super.Item;
/**
 * Contains a crowbar, a required item.
 * 
 * @see Ransacked_Quarters.Rqua_Pnl
 * @author Kevin Rapa
 */
public class Gqua_Skltn extends Furniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gqua_Skltn(Item... items) {
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
