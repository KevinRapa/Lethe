package Servants_Hall;

import Super.Furniture;
import Super.Item;
import Main.Player;

public class Sha2_Cbnt extends Furniture{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Sha2_Cbnt(Item... items) {
        super(items);
        this.searchable = false;
        this.description = "It's a large wooden double-doored cabinet. It looks\n"
                         + "plain and cheap. It must just house tools for the\n"
                         + "servants.";
        this.interactDialog = "The tiny metal key fits perfectly. You turn it and the\n"
                            + "cabinet makes a satisfying *click*";
        this.searchDialog = "The cabinet is locked. Maybe one of the servants\n"
                          + "had a key...";
        this.addActKeys("unlock", "open");
        this.addNameKeys("cabinet", "wood cabinet", "wooden cabinet");
    }    
//*----------------------------------------------------------------------------*/
    @Override public String interact(String key) {            
        if (Player.hasKey("CBNT") && ! this.searchable) {
            this.searchable = true; 
            return this.interactDialog;
        }
        else if (! this.searchable)
            return "The door won't open. It's locked.";
        
        else
            return "You have unlocked it. Perhaps you should search it.";
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
