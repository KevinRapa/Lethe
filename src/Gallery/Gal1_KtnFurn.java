package Gallery;

import A_Super.Furniture;
import A_Super.Item;
import A_Main.Player;

public class Gal1_KtnFurn extends Furniture { 
    private final Item REF;
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gal1_KtnFurn(Item ktn) {
        super();
        this.REF = ktn;
        this.searchable = false;
        this.description = "The black katana looks exceptionally sharp.";
        this.actDialog = "You take the katana off its display.";
        this.addActKeys("take", "grab", "hold", "get");
        this.addNameKeys("(?:black )?(?:katana|sword)");
    }
/*----------------------------------------------------------------------------*/ 
    @Override public String interact(String key) { 
        Player.getRoomRef("GAL1").removeFurniture(this);
        Player.getInv().add(REF);
           
        return this.actDialog;
    }
/*----------------------------------------------------------------------------*/    
    
}