package Courtyard;

import A_Super.Furniture;
import A_Main.Player;
import A_Super.Item;
/**
 * @author Mantis Toboggan
 */
public class Cou5_Sprc extends Furniture {
    private final Item EXTRCT_REF, VIAL_REF;
    private boolean drilled;
/* CONSTRUCTOR ---------------------------------------------------------------*/      
    public Cou5_Sprc(Item vial, Item extrct) {
        super();
        this.searchable = false;
        this.searchDialog = "There's nothing hiding in the branches, thankfully.";
        this.useDialog = "Drilling a small hole into the trunk allows a small\n"
                       + "sample of sap to ooze out.";
        this.description = "The ancient tree looms over you and creaks slowly in\n"
                         + "the breeze. It stands out as the most life-like thing\n"
                         + "in the courtyard.";
        this.EXTRCT_REF = extrct;
        this.VIAL_REF = vial;
        this.drilled = false;
        
        this.addNameKeys("tree", "spruce", "spruce tree");
        this.addUseKeys("hand drill", "empty vial");
    }
/*----------------------------------------------------------------------------*/
    @Override public String useEvent(Item item) {
        String rep;
        
        if (item.toString().matches("hand drill")) {
            if (drilled) {
                rep = "You have already drilled a small hole.";
            }
            else {
                drilled = true;
                rep = this.useDialog;
                
                if (Player.getInv().contains(VIAL_REF)) {
                    rep += " You collect some of the sap in the small vial you are carrying.";
                    Player.getInv().remove(VIAL_REF);
                    Player.getInv().add(EXTRCT_REF);
                }
                else
                    rep += " You have nothing to collect the sap in, though.";
            }
        }
        
        else {
            if (drilled) {
                rep = " You collect some of the sap in the small vial you are carrying.";
                Player.getInv().remove(VIAL_REF);
                Player.getInv().add(EXTRCT_REF);
            }
            else
                rep = "You have nothing to collect in the vial";
        }
        
        return rep;
    }
/*----------------------------------------------------------------------------*/
}
