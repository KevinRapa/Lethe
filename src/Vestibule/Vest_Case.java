package Vestibule;

import A_Super.Item;
import A_Super.Moveable;
import A_Super.Openable;
import A_Super.SearchableFurniture;

public class Vest_Case extends SearchableFurniture implements Openable, Moveable {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Vest_Case(Item... items) {
        super(items);
        this.description = "A white and blue ceramic case of Asian origin. The gold " +
                           "latch on its front looks unlocked.";
        this.searchDialog = "You open the case and look inside.";
        this.addNameKeys("(?:white and blue |white |blue )?(?:ceramic )?case");
    }
//-----------------------------------------------------------------------------
}
