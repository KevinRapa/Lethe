package Laboratory;

import A_Main.GUI;
import A_Main.Inventory;
import A_Main.Player;
import A_Super.Furniture;
import A_Super.Ingredient;
import A_Super.Item;
/**
 * @see Laboratory.Labo for solution
 * @author Kevin Rapa
 */
public class Labo_Flsk extends Furniture {
    private final Labo_Cndsr CONDENSER_REF;
    private final Item TUBE_REF, VIAL_REF;
    // ========================================================================
    public Labo_Flsk (Labo_Cndsr condenser, Item tstTb, Item vial) {
        super();
        
        this.CONDENSER_REF = condenser;
        this.TUBE_REF = tstTb;
        this.VIAL_REF = vial;
        
        this.description = "It's an empty glass flask with a bulbous base. This is the choice flask for distillation.";
        this.actDialog = "There's no reason to do that now.";
        this.searchDialog = "Here's what you've added.";
        
        this.addUseKeys("Br \\d{1,2}mL", 
                        "aether \\d{1,2}mL", 
                        "vinegar \\d{1,2}mL",
                        "wine \\d{1,2}mL", 
                        "H2CO3 \\d{1,2}mL", 
                        "HF \\d{1,2}mL",
                        "C20H14O4 \\d{1,2}mL", 
                        "chilled Br \\d{1,2}mL", 
                        "NaCl \\d{1,2}mL");
        
        this.inv = new Flsk_Inventory();

        this.addUseKeys(".+"); // Anything can be used on this, but it must be of type "ingredient".
        this.addNameKeys("(?:florence )?flask", "bulbous flask");
        this.addActKeys("take", "remove");
    }
    // ======================================================================== 
    public void distill() {
        if (this.inv.size() != 0 && CONDENSER_REF.condense(determineProduct())) 
            ((Flsk_Inventory)this.inv).emptyAndAddResidue();
    }
    // ======================================================================== 
    private int determineProduct() {
        if (this.inv.size() == 5 && 
                doesThisHaveIt("chilled Br 10mL") && 
                doesThisHaveIt("vinegar 5mL") && 
                doesThisHaveIt("ae 20mL") &&
                doesThisHaveIt("wine 15mL") && 
                doesThisHaveIt("H2CO3 35mL"))
            return 1;
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
        return "none";
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
            if (item.getType().equals("ingredient")) {
                GUI.out("You pour it in.");
                this.CONTENTS.add(item);
                Player.getInv().add(TUBE_REF);
                return true;
            }
            GUI.out("That's not an ingredient.");
            return false;
        }
        // ==========================================
        @Override public void give(Item item, Inventory giveToThis) {
            if (item.toString().equals("gray residue")) {
                this.remove(item);
                giveToThis.add(item);
                GUI.out("You take the residue out.");
            }
            else if (this.size() == 1) {
                if (Player.hasItem("test tube")) {
                    this.remove(item);
                    giveToThis.add(item);
                    Player.getInv().remove(TUBE_REF);
                    GUI.out("You take the residue out.");
                }
                else if (Player.hasItem("empty vial")) {
                    this.remove(item);
                    giveToThis.add(item);
                    Player.getInv().remove(VIAL_REF);
                    GUI.out("You take the residue out.");
                }
                else {
                    GUI.out("You have no vial or test tube to empty it out into.\n");
                }
            }
            else
                GUI.out("The ingredients are in solution. You can't take it back out.");
        }
        // ==========================================
        public void emptyAndAddResidue() {
            this.CONTENTS.clear();
            this.CONTENTS.add(new Ingredient("gray residue", "It smells awful! Just a product of distillation you suppose."));
        }
        // ==========================================
    }    
    // ========================================================================          
}


