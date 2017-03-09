package Marble_Hall;

import A_Main.AudioPlayer;
import static A_Main.NameConstants.SILVER_SPEAR;
import A_Super.Item;
import A_Main.Player;
import A_Super.SearchableFurniture;
/**
 * Player must find the silver spear located in the rack in Eow2 to open up
 * this statue's compartment, revealing the angel medallion.
 * 
 * @see Marble_Hall.Mha2_Door
 * @see East_Outer_Wall.Eow1_Rack
 * @author Kevin Rapa
 */
public class Mha2_RightStatue extends SearchableFurniture {
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
        this.addNameKeys("right (?:statue|one|angel|hand|compartment|palm)");
        this.addActKeys(HOLDPATTERN);
        this.addUseKeys(".+");
    }
/*----------------------------------------------------------------------------*/
    @Override public String useEvent(Item item) {
        if (item.toString().equals(SILVER_SPEAR)) {
            this.searchable = true;
            Player.getInv().remove(item);
            AudioPlayer.playEffect(44);
            this.addNameKeys("compartment", "open compartment");

            return this.useDialog;
        }
        else
            return "It doesn't seem like that belongs there.";
    }
/*----------------------------------------------------------------------------*/
    @Override public String getDescription() {
        if (this.searchable) {
            return "The angel poses majestically with an indifferent\n"
                 + "gaze upwards. It's a mirror-image of the left\n"
                 + "statue. In its right hand is a silver spear."; 
        }      
        else
            return this.description;
    }
/*----------------------------------------------------------------------------*/
     @Override public String getSearchDialog() {
        if (this.searchable)
            return "You look into the compartment inside the statue's base.";
        else
            return this.searchDialog;
    }
/*----------------------------------------------------------------------------*/
}
