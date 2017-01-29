package Kitchen;

import A_Main.GUI;
import A_Main.Inventory;
import static A_Main.NameConstants.COPPER_PAN;
import static A_Main.NameConstants.COPPER_POT;
import A_Main.Player;
import A_Super.Gettable;
import A_Super.Item;
import A_Super.SearchableFurniture;

public class Kitc_Pots extends SearchableFurniture implements Gettable {
    private final Item POT_REF, PAN_REF;
/* CONSTRUCTOR ---------------------------------------------------------------*/     
    public Kitc_Pots(Item pot, Item pan, Item ... items) {
        super();
        
        this.inv = new PotRack_Inventory(items);
        
        this.PAN_REF = pan;
        this.POT_REF = pot;
        
        this.description = "A bunch of old copper pots and pans hang from the\n"
                         + "ceiling";
        this.searchDialog = "You inspect the rack of pots.";
        this.actDialog = "That's very loud!";
        this.useDialog = "You store it.";
        
        this.addUseKeys(COPPER_POT, COPPER_PAN);
        this.addActKeys(GETKEYS);
        this.addActKeys(JOSTLEPATTERN, "rattle");
        this.addNameKeys("(?:old )?(?:copper )?(?:pots?|pans?)", "pots and pans");
    }
/*----------------------------------------------------------------------------*/
    @Override public String interact(String key) {              
        if (key.matches(JOSTLEPATTERN) || key.equals("rattle")) {
            if (this.inv.contents().isEmpty())
                return "You jostle the rack and mildly amuse yourself.";
            else 
                return this.actDialog;
        }
        else
            return getIt();
    }
/*----------------------------------------------------------------------------*/   
    @Override public String useEvent(Item item) {
        Player.getInv().give(item, this.inv);
        return this.useDialog;
    }
/*----------------------------------------------------------------------------*/
    @Override public String getIt() {
        if (! this.inv.contents().isEmpty()) {
            if (this.inv.contains(POT_REF) && Player.getInv().add(POT_REF)) {
                this.inv.remove(POT_REF);
                return "You take a pot off.";
            }
            else if (this.inv.contains(PAN_REF) && Player.getInv().add(PAN_REF)) {
                this.inv.remove(PAN_REF);
                return "You take a pan off.";
            }
            else
                return "You already have one of those.";
        }
        else
            return "The rack is empty.";
    }
    // ------------------------------------------------------------------------
    // ************************************************************************
    // ------------------------------------------------------------------------     
    private class PotRack_Inventory extends Inventory {
        public PotRack_Inventory(Item ... items) {
            super(items);
        }
        /*--------------------------------------------------------------------*/
        @Override public boolean add(Item item) {
            if (item.toString().equals(COPPER_POT) || item.toString().equals(COPPER_PAN)) {
                this.CONTENTS.add(item);
                return true;
            }
            else {
                GUI.out("That doesn't belong there!");
                return false;
            }
        }
    }
    // ------------------------------------------------------------------------        
    // ************************************************************************
    // ------------------------------------------------------------------------      
}
