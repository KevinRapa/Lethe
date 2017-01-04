package Vestibule;

import A_Super.Container;
import A_Super.Furniture;
import A_Super.Item;

public class Vest_Case extends Furniture implements Container {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Vest_Case(Item... items) {
        super(items);
        this.description = "A white and blue ceramic case of Asian origin. The gold " +
                           "latch on its front looks unlocked.";
        this.searchDialog = "You open the case and looks inside.";
        this.addNameKeys("(?:ceramic )?case");
    }
// ============================================================================
}
