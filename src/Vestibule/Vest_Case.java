package Vestibule;

import A_Super.Furniture;
import A_Super.Item;
import A_Super.Openable;

public class Vest_Case extends Furniture implements Openable {
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
