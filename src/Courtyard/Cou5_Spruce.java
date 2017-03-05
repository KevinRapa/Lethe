package Courtyard;

import A_Main.AudioPlayer;
import A_Main.Id;
import A_Main.Player;
import static A_Main.NameConstants.*;
import A_Super.Direction;
import A_Super.Item;
import A_Super.SearchableFurniture;
/**
 * This furniture provides spruce extract, a needed item.
 * 
 * @see Parlor.Par1_EnchtTbl
 * @author Kevin Rapa
 */
public class Cou5_Spruce extends SearchableFurniture {
    private final Item EXTRCT_REF, VIAL_REF;
    private boolean drilled;
/* CONSTRUCTOR ---------------------------------------------------------------*/      
    public Cou5_Spruce(Item vial, Item extrct, Item ... items) {
        super(items);
        this.searchDialog = "There doesn't seem to be much...";
        this.useDialog = "Drilling a small hole into the trunk allows a small\n"
                       + "sample of sap to ooze out.";
        this.description = "The ancient tree looms over you and creaks slowly in\n"
                         + "the breeze. It stands out as the most life-like thing\n"
                         + "in the courtyard, even more than the birds. The spruce\n"
                         + "is an evergreen, genus Abies, with stiff sharp needles.\n"
                         + "The closely-spaced branches make climbing a possibility.";
        this.EXTRCT_REF = extrct;
        this.VIAL_REF = vial;
        this.drilled = false;
        
        this.addActKeys("drill", "climb", "swing", "scale");
        this.addNameKeys("(?:spruce )?tree", "spruce", "trunk", "branch(?:es)?");
        this.addUseKeys(HAND_DRILL, EMPTY_VIAL);
    }
/*----------------------------------------------------------------------------*/
    @Override public String useEvent(Item item) {
        if (item.toString().equals(HAND_DRILL)) {
            if (drilled) {
                return "You have already drilled a small hole.";
            }
            else {
                this.addNameKeys("(?:tree ?)?sap", "hole");
                drilled = true;
                AudioPlayer.playEffect(33);
                String rep = this.useDialog;
                
                if (Player.getInv().contains(VIAL_REF)) {
                    Player.getInv().remove(VIAL_REF);
                    Player.getInv().add(EXTRCT_REF);
                    return rep.concat(" You collect some of the sap in the small vial you are carrying.");
                }
                else
                    return rep.concat(" You have nothing to collect the sap in, though.");
            }
        }
        else {
            if (drilled) {
                Player.getInv().remove(VIAL_REF);
                Player.getInv().add(EXTRCT_REF);
                return " You collect some of the sap in the small vial you are carrying.";
            }
            else
                return "You have nothing to collect in the vial";
        }
    }
/*----------------------------------------------------------------------------*/
    @Override public String interact(String action) {
        if (action.equals("drill")) {
            if (Player.hasItem(HAND_DRILL))
                return this.useEvent(new Item(HAND_DRILL));
            else
                return "You have nothing to drill into it with.";
        }
        else if (action.equals("climb") || action.equals("scale")) {
            if (Player.getPosId().equals(Id.COU8)) {
                Player.move(Direction.DOWN);
                return "You are uncomfortable with the idea of spending any\n"
                     + "greater time up there on such a windy night. You carefully\n"
                     + "climb back down into the courtyard.";
            } 
            else {
                Player.move(Direction.UP);
                return "You carefully climb up the tree. The closely-spaced branches\n"
                 + "of the spruce make the climb easier than in most trees, however\n"
                 + "the stiff spruce needles scrape and jab your skin through your\n"
                 + "flannel shirt.";
            }
        }
        else
            return "You're much too old for that.";
    }
/*----------------------------------------------------------------------------*/
}
