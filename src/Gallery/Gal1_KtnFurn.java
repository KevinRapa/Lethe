package Gallery;

import Super.Furniture;
import Super.Item;
import Main.Inventory;
import Super.Room;

public class Gal1_KtnFurn extends Furniture { 
    private final Inventory REF;
    private final Item REF2;
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gal1_KtnFurn(Inventory inv, Item ktn) {
        super();
        this.REF = inv;
        this.REF2 = ktn;
        this.searchable = false;
        this.description = "The black katana looks exceptionally sharp.";
        this.interactDialog = "You take the katana off its display.";
        this.addActKeys("take", "grab", "hold", "get");
        this.addNameKeys("katana", "sword");
    }
/*----------------------------------------------------------------------------*/ 
    @Override public String interact(Room[][][] map, String key) { 
        Room gal1 = map[3][2][6];
        gal1.removeFurniture(this);
        REF.add(REF2);
           
        return this.interactDialog;
    }
/*----------------------------------------------------------------------------*/    
    
}