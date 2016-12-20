package Gallery;

import Super.Furniture;
import Super.Item;
import Main.Inventory;
import Super.Room;

public class Gal3_InstFurn extends Furniture { 
    private final Inventory REF;
    private final Item REF2;
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gal3_InstFurn(Inventory inv, Item inst) {
        super();
        this.REF = inv;
        this.REF2 = inst;
        this.searchable = false;
        this.description = "You've never seen anything like this before. You'd\n"
                         + "call it a guitar, but then again, it looks like a\n"
                         + "harp too. Beneath it you see a small label: \"Kora\".";
        this.interactDialog = "You carefully remove the instrument from its display.";
        this.addNameKeys("instrument", "stringed instrument", "kora");
        this.addActKeys("take", "grab", "hold", "play", "strum");
    }
/*----------------------------------------------------------------------------*/ 
    @Override public String interact(Room[][][] map, String key) { 
        String rep = this.interactDialog;
        
        if (key.matches("strum") || key.matches("play")) {
            rep = "You would try, but it's up on the wall right now.";
        }            
        else {
            Room gal1 = map[3][2][6];
            gal1.removeFurniture(this);
            REF.add(REF2);
        }
        return rep;
    }
/*----------------------------------------------------------------------------*/    
    
}
