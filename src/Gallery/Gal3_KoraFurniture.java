package Gallery;

import A_Main.Id;
import A_Super.Furniture;
import A_Main.Player;
import A_Super.Item;

public class Gal3_KoraFurniture extends Furniture { 
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gal3_KoraFurniture() {
        super();

        this.description = "You've never seen anything like this before. You'd "
                         + "call it a guitar, but then again, it looks like a "
                         + "harp too. Beneath it you see a small label: \"Kora\".";
        this.actDialog = "You carefully remove the instrument from its display.";
        this.addNameKeys("(?:stringed )?instrument", "kora");
        this.addActKeys(GETPATTERN, "hold", "play", "strum");
    }
/*----------------------------------------------------------------------------*/ 
    @Override public String interact(String key) { 
        if (key.matches("strum|play"))
            return "You would try, but it's up on the wall right now.";     
        else
            if (Player.getInv().add(new Gal3_Inst("kora"))) {
                Player.getRoomObj(Id.GAL3).removeFurniture(this);
                return this.actDialog;
            }
            else
                return NOTHING;
    }
/*----------------------------------------------------------------------------*/    
    private class Gal3_Inst extends Item {
        public Gal3_Inst (String name) {
            super(name, 30);
            this.useID = 1;
            this.description = "The exotic instrument consists of a half-sphere for "
                             + "a body and a long neck. But it resembles a harp more "
                             + "than a guitar or cello.";
            this.useDialog = "You give it a strum. 'Sounds terrible!' you think, "
                           + "although you've never played a kora before. The sound "
                           + "itself is actually quite nice, like that of a "
                           + "classical guitar.";
        }
    /*------------------------------------------------------------------------*/
    }
}
