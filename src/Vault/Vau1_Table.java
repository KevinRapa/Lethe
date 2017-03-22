package Vault;

import static A_Main.Names.GLOWING_CHALICE;
import A_Super.Item;
import A_Super.Moveable;
import A_Super.SearchableFurniture;
/**
 * @author Kevin Rapa
 */
public class Vau1_Table extends SearchableFurniture implements Moveable {
    // ========================================================================
    public Vau1_Table (Item... items) {
        super(items);
        
        this.description = "It's a clean marble table resting on two short columns.\n"
                         + "A satin tablecloth is draped over it";
        this.searchDialog = "You look on the table.";

        this.addNameKeys("(?:clean )?(?:marble )?table");
    }
    // ======================================================================== 
    @Override public String getDescription() {
        return this.containsItem(GLOWING_CHALICE) ? 
                this.description.concat(", and a glowing chalice rests on its surface.") :
                this.description.concat(".");
    }
    // ========================================================================     
}


