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
        this.addNameKeys("cabinet", "wood cabinet", "wooden cabinet");
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
        String rep = this.searchDialog;
        
        if (Player.hasKey("CBNT") && ! this.searchable) {
            rep = "It's locked but you have a key that looks like it might\n"
                   + "fit. Maybe you should try to unlock the cabinet?";}
        
        else if (this.searchable)
            rep = "You look inside the cabinet.";

        return rep; 
    }
/*----------------------------------------------------------------------------*/
}
