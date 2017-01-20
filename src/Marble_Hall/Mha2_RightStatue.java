package Marble_Hall;

import static A_Main.NameConstants.SILVER_SPEAR;
import A_Super.Furniture;
import A_Super.Item;
import A_Main.Player;

public class Mha2_RightStatue extends Furniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/     
    public Mha2_RightStatue(Item... items) {
        super(items);
        this.searchable = false;
        this.description = "The angel poses majestically with an indifferent\n"
                         + "gaze upwards. It's a mirror-image of the left\n"
                         + "statue, though its hand is empty.";
        this.searchDialog = "There looks to be no compartment on this one.";
        this.useDialog = "You slide the spear back into the angel's grasp. The\n"
                       + "divines will be pleased with you. A compartment\n"
                       + "reveals itself at the statue's base.";
        this.actDialog = "Such an impressive work of artistry deserves not to be\n"
                            + "tainted by your touch.";
        this.addNameKeys("right statue", "right compartment");
        this.addActKeys("touch", "grab", "hold");
        this.addUseKeys(SILVER_SPEAR);
    }
/*----------------------------------------------------------------------------*/
    @Override public String useEvent(Item item) {
        this.searchable = true;
        Player.getInv().remove(item);
        this.addNameKeys("compartment", "open compartment");
            
        return this.useDialog;
    }
/*----------------------------------------------------------------------------*/
    @Override public String getDescription() {
        if (this.searchable) {
            return "The angel poses majestically with an indifferent\n"
                 + "gaze upwards. It's a mirror-image of the left\n"
                 + "statue. In its right hand is a silver spear."; 
        }      
        return this.description;
    }
/*----------------------------------------------------------------------------*/
     @Override public String getSearchDialog() {
        if (this.searchable)
            return "You look into the compartment inside the statue's base.";
        
        return this.searchDialog;
    }
/*----------------------------------------------------------------------------*/
}
