package Gallery;

import A_Super.Furniture;
import A_Super.Item;
import A_Main.Player;

public class Gal3_InstFurn extends Furniture { 
    private final Item REF;
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gal3_InstFurn(Item inst) {
        super();
        this.REF = inst;
        this.searchable = false;
        this.description = "You've never seen anything like this before. You'd\n"
                         + "call it a guitar, but then again, it looks like a\n"
                         + "harp too. Beneath it you see a small label: \"Kora\".";
        this.actDialog = "You carefully remove the instrument from its display.";
        this.addNameKeys("instrument", "stringed instrument", "kora");
        this.addActKeys("take", "grab", "hold", "play", "strum");
    }
/*----------------------------------------------------------------------------*/ 
    @Override public String interact(String key) { 
        if (key.matches("strum|play")) {
            return "You would try, but it's up on the wall right now.";
        }            
        else {
            Player.getRoomRef("GAL3").removeFurniture(this);
            Player.getInv().add(REF);
        }
        return this.actDialog;
    }
/*----------------------------------------------------------------------------*/    
    
}
