package Courtyard;

import Super.Furniture;
import Core.Inventory;
import Super.Item;
/**
 * @author Mantis Toboggan
 */
public class Cou5_Sprc extends Furniture {
    private final Inventory REF;
    private final Item REF2;
/* CONSTRUCTOR ---------------------------------------------------------------*/      
    public Cou5_Sprc(String NAME, Inventory inv, Item extrct) {
        super(NAME);
        this.searchable = false;
        this.searchDialog = "There's nothing hiding in the branches, thankfully.";
        this.useDialog = "Drilling a small hole into the trunk allows a small\n"
                       + "sample of sap to ooze out.";
        this.description = "The ancient tree looms over you and creaks slowly in\n"
                         + "the breeze. It stands out as the most life-like thing\n"
                         + "in the courtyard.";
        this.REF = inv;
        this.REF2 = extrct;
        
        this.addNameKeys("tree", "spruce", "spruce tree");
        this.addUseKeys("hand drill");
    }
/*----------------------------------------------------------------------------*/
    @Override public String useEvent(Item item) {
        
        REF.add(REF2);
        
        return this.useDialog;
    }
/*----------------------------------------------------------------------------*/
}
