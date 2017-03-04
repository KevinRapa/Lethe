package Gallery;

import A_Super.Furniture;
import A_Super.Item;
import A_Main.Player;

public class Gal3_Rope extends Furniture {
    private boolean cut;
    private final Gal3_Ladder REF;
/* CONSTRUCTOR ---------------------------------------------------------------*/        
    public Gal3_Rope(Furniture lddr) {
            super();
            this.cut = false;
            this.REF = (Gal3_Ladder)lddr;
            
            this.actDialog = "You cut the rope with the katana. The ladder\n"
                           + "drops down into the room, giving access to\n"
                           + "the loft.";
            this.description = "The rope is tied to the ladder and hoists it up\n"
                             + "with a pulley. It feeds into a hole in the wall\n"
                             + "next to you. Above the hole, you see a switch.";
            this.searchDialog = "It's just an ordinary rope.";
            
            this.addActKeys("cut", "pull", "untie");
            this.addUseKeys("katana", "(?:silver|rusty|broken) sword", "(?:war|battle) axe");
            this.addNameKeys("rope");
    }
/*----------------------------------------------------------------------------*/    
    @Override public String getDescription() {
        return this.cut ? "The rope is now cut." : this.description;
    }
/*----------------------------------------------------------------------------*/ 
    @Override public String interact(String key) { 
        if (! this.cut) {
            if (key.equals("cut")) {
                if (detectItem()) {
                    REF.lower();
                    this.cut = true;
                    return this.actDialog;
                }           
                else
                    return "You have nothing to cut the rope with.";
            }       
            else if (key.equals("pull")) 
                return "The rope doesn't budge.";  
            
            else 
                return "The knot in the rope is too high up to untie.";    
        }
        else
            return "The rope is cut already";
    }
/*----------------------------------------------------------------------------*/
    @Override public String useEvent(Item item) {
        REF.lower();
        this.cut = true;
        
        return "You cut the rope with the " + item + ".\n"
             + "The ladder drops down into the room,\n"
             + "giving access to the loft.";
    }
/*----------------------------------------------------------------------------*/
    private boolean detectItem() {
        // Detects if you have a blade to cut the rope with.
        return this.USEKEYS.stream().anyMatch(i -> (Player.hasItem(i.toString())));
    }
/*----------------------------------------------------------------------------*/
}
