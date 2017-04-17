package Laboratory;

import A_Main.GUI;
import A_Main.Inventory;
import A_Main.Names;
import A_Main.Player;
import A_Super.Item;
import A_Super.SearchableFurniture;
/**
 * @see Laboratory.Labo for solution
 * @author Kevin Rapa
 */
public class Labo_Flask extends SearchableFurniture {
    private final Labo_Condenser CONDENSER_REF;
    private final Item TUBE_REF, VIAL_REF;
    // ========================================================================
    public Labo_Flask (Labo_Condenser condenser, Item tstTb, Item vial) {
        super();
        
        this.CONDENSER_REF = condenser;
        this.TUBE_REF = tstTb;
        this.VIAL_REF = vial;
        
        this.description = "It's an empty glass flask with a bulbous base. This is the choice flask for distillation.";
        this.actDialog = "There's no reason to do that now.";
        this.searchDialog = "Here's what you've added.";
        
        // Will accept any ingredient (item with 'mL')
        this.addUseKeys("(?:chilled )?[\\w\\d]+ \\d{1,2}mL");
        
        this.inv = new Flsk_Inventory();

        this.addUseKeys(ANYTHING); // Anything can be used on this, but it must be of type "ingredient".
        this.addNameKeys("(?:florence |bulbous )?flask");
        this.addActKeys(GETPATTERN);
    }
    // ======================================================================== 
    public void distill() {
        if (this.inv.size() != 0 && CONDENSER_REF.condense(determineProduct())) 
            ((Flsk_Inventory)this.inv).emptyAndAddResidue();
        else if (this.inv.size() == 0)
            GUI.out("You strike the burner, producing an aggressive flame. The "
                  + "flame heats the empty flask for about a minute, yielding "
                  + "no interesting results.");
    }
    // ======================================================================== 
    private int determineProduct() {
        if (this.inv.size() == 6 && 
                containsItem("chilled Br 10mL") && 
                containsItem("vinegar 5mL") && 
                containsItem("ae 20mL") &&
                containsItem("wine 15mL") && 
                containsItem("chilled H2O 30mL") && 
                containsItem("H2CO3 35mL")) 
        {
            return 1;
        }
        else
            return 0;
    }
    // ======================================================================== 
    @Override public String getDescription() {
        switch (this.inv.size()) {
            case 0:
                return this.description;
            case 1:
                return "The glass flask contains " + this.inv.get(0) + ".";
            default:
                return "The glass flask contains a solution of... stuff.";
        }
    }
    // ========================================================================     
    @Override public String useEvent(Item item) {
        Player.getInv().give(item, this.inv);
        return NOTHING;
    }
    // ========================================================================    
    // ************************************************************************
    // ========================================================================    
    private class Flsk_Inventory extends Inventory {
        // ==========================================
        public Flsk_Inventory() {
            super();
        }
        // ==========================================
        @Override public boolean add(Item item) {
            if (item.getType().equals(Names.INGREDIENT)) {
                GUI.out("You pour it in.");
                this.CONTENTS.add(item);
                Player.getInv().forceAdd(TUBE_REF);
                return true;
            }
            GUI.out("That's not an ingredient!");
            return false;
        }
        // ==========================================
        @Override public boolean give(Item item, Inventory giveToThis) {
            if (item.toString().equals("gray residue")) {
                this.remove(item);
                giveToThis.add(item); // Residue unneeded. No need to force in.
                GUI.out("You take the residue out.");
                return true;
            }
            else if (this.size() == 1) {
                if (giveToThis.contains(TUBE_REF)) {
                    this.remove(item);
                    giveToThis.remove(TUBE_REF);
                    giveToThis.forceAdd(item);
                    GUI.out("You pour it back out.");
                    return true;
                }
                else if (giveToThis.contains(VIAL_REF)) {
                    this.remove(item);
                    giveToThis.remove(VIAL_REF);
                    giveToThis.forceAdd(item);
                    GUI.out("You pour it back out.");
                    return true;
                }
                else {
                    GUI.out("You have no vial or test tube to empty it out into. ");
                    return false;
                }
            }
            else {
                GUI.out("The ingredients are in solution. You can't take it back out.");
                return false;
            }
        }
        // ==========================================
        public void emptyAndAddResidue() {
            this.CONTENTS.clear();
            this.CONTENTS.add(new Item("gray residue", "It smells awful! Just a product of distillation you suppose.", -50));
        }
        // ==========================================
    }    
    // ========================================================================          
}


