package Servants_Hall;

import A_Super.Furniture;
import A_Super.Item;
import A_Super.Container;
import A_Main.Player;

public class Sha2_Cbnt extends Furniture implements Container {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Sha2_Cbnt(Item... items) {
        super(items);
        this.searchable = false;
        this.description = "It's a large wooden double-doored cabinet. It looks\n"
                         + "plain and cheap. It must just house tools for the\n"
                         + "servants.";
        this.actDialog = "The tiny metal key fits perfectly. You turn it and the\n"
                            + "cabinet makes a satisfying *click*";
        this.searchDialog = "The cabinet is locked. Maybe one of the servants\n"
                          + "had a key...";
        this.addActKeys("unlock");
        this.addNameKeys("cabinet", "(?:large )?(?:wood(?:en)? )?(?:double-doored )?cabinet");
    }    
//*----------------------------------------------------------------------------*/
    @Override public String interact(String key) {            
        if (Player.hasKey("CBNT") && ! this.searchable) {
            this.searchable = true; 
            return this.actDialog;
        }
        else if (! this.searchable)
            return "The door won't open. It's locked.";
        
        else
            return "You have unlocked it already.";
    }
/*----------------------------------------------------------------------------*/
    @Override public String getSearchDialog() {
        if (Player.hasKey("CBNT") && ! this.searchable) {
            this.searchable = true;
            return this.actDialog;
        }
        else if (this.searchable)
            return "You look inside the cabinet.";

        return this.searchDialog;
    }
/*----------------------------------------------------------------------------*/
}
