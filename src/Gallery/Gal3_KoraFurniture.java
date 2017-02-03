package Gallery;

import A_Main.Id;
import A_Super.Furniture;
import A_Main.Player;
import A_Super.Item;

public class Gal3_KoraFurniture extends Furniture { 
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gal3_KoraFurniture() {
        super();

        this.description = "You've never seen anything like this before. You'd\n"
                         + "call it a guitar, but then again, it looks like a\n"
                         + "harp too. Beneath it you see a small label: \"Kora\".";
        this.actDialog = "You carefully remove the instrument from its display.";
        this.addNameKeys("instrument", "stringed instrument", "kora");
        this.addActKeys(GETPATTERN);
        this.addActKeys("hold", "play", "strum");
    }
/*----------------------------------------------------------------------------*/ 
    @Override public String interact(String key) { 
        if (key.matches("strum|play")) {
            return "You would try, but it's up on the wall right now.";
        }            
        else {
            Player.getRoomObj(Id.GAL3).removeFurniture(this);
            Player.getInv().add(new Gal3_Inst("kora"));
        }
        return this.actDialog;
    }
/*----------------------------------------------------------------------------*/    
    private class Gal3_Inst extends Item {
        public Gal3_Inst (String name) {
            super(name);
            this.useID = 1;
            this.description = "The exotic instrument consists of a half-sphere for\n"
                             + "a body and a long neck. But it resembles a harp more\n"
                             + "than a guitar or cello.";
            this.useDialog = "You give it a strum. 'Sounds terrible!' you think,\n"
                           + "although you've never played a kora before. The sound\n"
                           + "itself is actually quite nice, like that of a\n"
                           + "classical guitar.";
        }
    /*------------------------------------------------------------------------*/
    }
}
