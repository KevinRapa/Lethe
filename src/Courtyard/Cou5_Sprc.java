package Courtyard;

import Super.Furniture;
import Main.Inventory;
import Main.Player;
import Super.Item;
/**
 * @author Mantis Toboggan
 */
public class Cou5_Sprc extends Furniture {
    private final Item REF2, REF3;
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
        this.REF2 = extrct;
        this.REF3 = vial;
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
                
                if (Player.getINV().getInv().contains(REF3)) {
                    rep += " You collect some of the sap in the small vial you are carrying.";
                    Player.getINV().remove(REF3);
                    Player.getINV().add(REF2);
                }
                else
                    rep += " You have nothing to collect the sap in, though.";
            }
        }
        
        else {
            if (drilled) {
                rep = " You collect some of the sap in the small vial you are carrying.";
                Player.getINV().remove(REF3);
                Player.getINV().add(REF2);
            }
            else
                rep = "You have nothing to collect in the vial";
        }
        
        return rep;
    }
/*----------------------------------------------------------------------------*/
}
