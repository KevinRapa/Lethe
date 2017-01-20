package Ancient_Tomb;

import A_Super.Furniture;
import A_Super.Item;
/**
 * @author Kevin Rapa
 */
public class Ant_Ceiling extends Furniture {
    // ========================================================================
    public Ant_Ceiling (Item... items) {
        super(items);
        this.searchable = false;
        
        this.description = "The sandstone brick ceiling arches gently over your head.";
        this.searchDialog = "It's a ceiling...";

        this.addNameKeys("(?:low )?(?:arched )?ceiling");
    }
    // ======================================================================== 
}


