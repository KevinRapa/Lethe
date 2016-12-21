package Gallery;

import Super.Furniture;
import Super.Item;
import Main.Player;
import Super.Room;

public class Gal1_KtnFurn extends Furniture { 
    private final Item REF2;
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gal1_KtnFurn(Item ktn) {
        super();
        this.REF2 = ktn;
        this.searchable = false;
        this.description = "The black katana looks exceptionally sharp.";
        this.interactDialog = "You take the katana off its display.";
        this.addActKeys("take", "grab", "hold", "get");
        this.addNameKeys("katana", "sword");
    }
/*----------------------------------------------------------------------------*/ 
    @Override public String interact(String key) { 
        Room gal1 = Player.getMapRef()[3][2][6];
        gal1.removeFurniture(this);
        Player.getINV().add(REF2);
           
        return this.interactDialog;
    }
/*----------------------------------------------------------------------------*/    
    
}