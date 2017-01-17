package Vault;

import A_Super.Furniture;
import A_Super.Item;
/**
 * @author Kevin Rapa
 */
public class Vau1_Tbl extends Furniture {
    // ========================================================================
    public Vau1_Tbl (Item... items) {
        super(items);
        
        this.description = "It's a clean marble table resting on two short columns.\n"
                         + "A satin tablecloth is draped over it";
        this.searchDialog = "You look on the table.";

        this.addNameKeys("(?:clean )?(?:marble )?table");
    }
    // ======================================================================== 
    @Override public String getDescription() {
        return this.containsItem("glowing chalice") ? 
                this.description.concat(", and a glowing chalice rests on its surface.") :
                this.description.concat(".");
    }
    // ========================================================================     
}


