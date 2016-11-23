package Vestibule;

import Super.Furniture;
import Super.Item;

public class Vest_Case extends Furniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Vest_Case(String NAME, Item ... items) {
        super(NAME, items);
        this.description = "A white and blue ceramic case of Asian origin. The gold " +
                           "latch on its front looks unlocked.";
        this.searchDialog = "You open the case and looks inside.";
        this.interactDialog = "'If you're going to open this case, you're going to\n"
                    + "take anything inside. Better search it instead.'";
        this.addNameKeys("case", "ceramic case");
        this.addActKeys("open");
    }
}
