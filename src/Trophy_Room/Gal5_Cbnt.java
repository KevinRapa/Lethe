package Trophy_Room;

import A_Super.Furniture;
import A_Super.Item;
import A_Super.Container;
import A_Main.Player;

public class Gal5_Cbnt extends Furniture implements Container {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gal5_Cbnt(Item... items) {
        super(items);
        this.searchable = false;
        this.actDialog = "The tiny gold key fits perfectly. You turn it and the\n"
                            + "cabinet makes a satisfying *click*.";
        this.description = "It's a large wooden double-doored cabinet. It is fancily\n"
                         + "carved and looks as though it holds something valuable.";
        this.searchDialog = "The cabinet is locked. Looks like you'll need a key.";
        this.addActKeys("unlock");
        this.addNameKeys("curio cabinet", "wood cabinet", "cabinet");
    }    
//*----------------------------------------------------------------------------*/
    @Override public String interact(String key) {            
        if (Player.hasKey("GCBT") && ! this.searchable) {
            this.searchable = true; 
            return this.actDialog;
        }
        else if (! this.searchable)
            return "The door won't open. You'll need a key.";
        
        else return "You have unlocked it already.";
    }
/*----------------------------------------------------------------------------*/
    @Override public String getSearchDialog() {
        String rep = this.searchDialog;
        
        if (Player.hasKey("GCBT") && ! this.searchable) 
            rep = "It's locked but you have a key that looks like it might unlock it.";
        
        else if (this.searchable)
            rep = "You look inside the cabinet.";

        return rep; 
    }
/*----------------------------------------------------------------------------*/
}

