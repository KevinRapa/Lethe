package Gallery;

import Super.Furniture;
import Super.Item;
import Main.Player;

public class Gal3_Rp extends Furniture {
    private boolean cut;
    private final Gal3_Lddr REF2;
/* CONSTRUCTOR ---------------------------------------------------------------*/        
    public Gal3_Rp(Furniture lddr) {
            super();
            this.searchable = false;
            this.cut = false;
            this.REF2 = (Gal3_Lddr)lddr;
            this.addActKeys("cut", "pull", "untie");
            this.addUseKeys("katana", "silver sword", "rusty sword", "broken sword", "war axe", "battle axe");
            this.addNameKeys("rope");
            this.interactDialog = "You cut the rope with the katana. The ladder\n"
                                + "drops down into the room, giving access to\n"
                                + "the loft.";
            this.description = "The rope is tied to the ladder and hoists it up\n"
                             + "with a pulley. It feeds into a hole in the wall\n"
                             + "next to you. Above the hole, you see a switch.";
            this.searchDialog = "It's just an ordinary rope.";
    }
/*----------------------------------------------------------------------------*/    
    @Override public String getDescription() {
        String rep = this.description;
        
        if (this.cut) {
            rep = "The rope is now cut.";
        }
        return rep;
    }
/*----------------------------------------------------------------------------*/ 
    @Override public String interact(String key) { 
        String rep = this.interactDialog;
        
        if(! this.cut) {
            if (key.matches("cut")) {
                if (detectItem()) {
                    REF2.lower();
                    this.cut = true;
                }           
                else
                    rep = "You have nothing to cut the rope with.";
            }       
            else if (key.matches("pull")) {
                rep = "Pulling the rope is doing the opposite of what you want.";    
                    }      
            else if (key.matches("untie")) {
                rep = "The knot in the rope is too high up to untie.";    
                    }
            }
        else
            rep = "The rope is cut already";
               
        return rep;
    }
/*----------------------------------------------------------------------------*/
    @Override public String useEvent(Item item) {
        REF2.lower();
        this.cut = true;
        
        return "You cut the rope with the " + item + ".\n"
             + "The ladder drops down into the room,\n"
             + "giving access to the loft.";
    }
/*----------------------------------------------------------------------------*/
    private boolean detectItem() {
        // Detects if you have a blade to cut the rope with.
        for (String i : this.USEKEYS) {
            if (Player.doYouHaveIt(i))
                return true;
        }
        return false;
    }
/*----------------------------------------------------------------------------*/
}
