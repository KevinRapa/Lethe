package Trophy_Room;

import Super.Furniture;
import Super.Item;
import Main.Player;

public class Gal5_Cbnt extends Furniture{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gal5_Cbnt(Item... items) {
        super(items);
        this.searchable = false;
        this.interactDialog = "The tiny gold key fits perfectly. You turn it and the\n"
                            + "cabinet makes a satisfying *click*.";
        this.description = "It's a large wooden double-doored cabinet. It is fancily\n"
                         + "carved and looks as though it holds something valuable.";
        this.searchDialog = "The cabinet is locked. Looks like you'll need a key.";
        this.addActKeys("unlock", "open");
        this.addNameKeys("curio cabinet", "wood cabinet", "cabinet");
    }    
//*----------------------------------------------------------------------------*/
    @Override public String interact(String key) {            
        if (Player.hasKey("GCBT") && ! this.searchable) {
            this.searchable = true; 
            return this.interactDialog;
        }
        else if (! this.searchable)
            return "The door won't open. You'll need a key.";
        
        else
            return "You have unlocked it. Perhaps you should search it.";
    }
/*----------------------------------------------------------------------------*/
    @Override public String getSearchDialog() {
        String rep = this.searchDialog;
        
        if (Player.hasKey("GCBT") && ! this.searchable) {
            rep = "It's locked but you have a key that looks like it might\n"
                + "fit. Maybe you should try to unlock the cabinet?";}
        
        else if (this.searchable)
            rep = "You look inside the cabinet.";

        return rep; 
    }
/*----------------------------------------------------------------------------*/
}

