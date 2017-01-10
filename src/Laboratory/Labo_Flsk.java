package Laboratory;

import A_Super.Furniture;
import A_Super.Ingredient;
/**
 * @see Laboratory.Labo for solution
 * @author Kevin Rapa
 */
public class Labo_Flsk extends Lab_Glassware {
    private final Labo_Cndsr CONDENSER_REF;
    // ========================================================================
    public Labo_Flsk (Furniture distiller, Labo_Cndsr condenser) {
        super();
        
        this.CONDENSER_REF = condenser;
        this.description = "It's an empty glass flask with a bulbous base. This is the choice flask for distillation.";
        this.actDialog = "There's no reason to do that now.";
 
        this.addUseKeys("bromine, \\d{1,2}mL", 
                        "aether, \\d{1,2}mL", 
                        "vinegar, \\d{1,2}mL",
                        "wine, \\d{1,2}mL", 
                        "carbonic acid, \\d{1,2}mL", 
                        "hydroflouric acid, \\d{1,2}mL",
                        "phenolphthalein, \\d{1,2}mL", 
                        "chilled bromine, \\d{1,2}mL", 
                        "sodium chloride, \\d{1,2}mL");
        
        this.addNameKeys("(?:florence )?flask", "bulbous flask");
        this.addActKeys("take", "remove");
    }
    // ======================================================================== 
    public void distill() {
        if (this.inv.size() != 0 && CONDENSER_REF.condense(determineProduct())) {
            this.inv.contents().clear();
            this.inv.add(new Ingredient("gray residue", "It smells awful! Just a product of distillation you suppose."));
        }
    }
    // ======================================================================== 
    private int determineProduct() {
        if (this.inv.size() == 5 && 
                doesThisHaveIt("chilled bromine, 10mL") && 
                doesThisHaveIt("vinegar, 5mL") && 
                doesThisHaveIt("aether, 15mL") &&
                doesThisHaveIt("wine, 10mL") && 
                doesThisHaveIt("carbonic acid, 35mL"))
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
}


