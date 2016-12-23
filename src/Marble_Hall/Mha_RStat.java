package Marble_Hall;

import A_Super.Furniture;
import A_Super.Item;
import A_Main.Player;

public class Mha_RStat extends Furniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/     
    public Mha_RStat(Item... items) {
        super(items);
        this.searchable = false;
        this.description = "The angel poses majestically with an indifferent\n"
                         + "gaze upwards. It's a mirror-image of the left\n"
                         + "statue, though its hand is empty.";
        this.searchDialog = "There looks to not be compartment on this one.";
        this.useDialog = "You slide the spear back into the angel's grasp. The\n"
                       + "divines will be pleased with you. A compartment\n"
                       + "reveals itself at the statue's base.";
        this.actDialog = "Such an impressive work of artistry deserves not to be\n"
                            + "tainted by your touch.";
        this.addNameKeys("right statue");
        this.addActKeys("touch", "grab", "hold");
        this.addUseKeys("silver spear");
    }
/*----------------------------------------------------------------------------*/
    @Override public String useEvent(Item item) {
        this.searchable = true;
        Player.getInv().remove(item);
            
        return this.useDialog;
    }
/*----------------------------------------------------------------------------*/
    @Override public String getDescription() {
        String rep = this.description;
        
        if (this.searchable) {
            rep = "The angel poses majestically with an indifferent\n"
                + "gaze upwards. It's a mirror-image of the left\n"
                + "statue. In its right hand is a silver spear."; 
        }      
        return rep;
    }
/*----------------------------------------------------------------------------*/
     @Override public String getSearchDialog() {
        String rep = this.searchDialog;
        
        if (this.searchable)
            rep = "You look into the compartment inside the statue's base.";
        
        return rep;
    }
/*----------------------------------------------------------------------------*/
}
