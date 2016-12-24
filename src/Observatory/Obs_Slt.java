package Observatory;

import A_Super.Furniture;
import A_Super.Item;

public class Obs_Slt extends Furniture {
    private final String CORRECT;
/* CONSTRUCTOR ---------------------------------------------------------------*/      
    public Obs_Slt(String NAME, String correct, String desc, Item ... items) {
            super();
            this.CORRECT = correct;
            this.description = desc;
            this.searchDialog = "This indentation in the floor reads, " + desc.substring(17) + "."; 
            this.addNameKeys(NAME, NAME.toLowerCase());
            this.inv = new Slt_Inv(items);
    }
/*----------------------------------------------------------------------------*/
    public boolean isCorrect() {
        if (this.inv.size() == 1) {
            String plateName = this.inv.get(0).toString().substring(14).replaceAll("\"", "");
            return this.CORRECT.matches(plateName);
        }
        else return false;
    }
/*----------------------------------------------------------------------------*/
    @Override public String getSearchDialog() {
        if (this.inv.size() == 1 && this.searchable)
            return "A plate has been fit into the slot.";
        else
            return this.searchDialog;
    }
/*----------------------------------------------------------------------------*/
    @Override public String getDescription() {
        if (this.inv.size() == 1)
            return "The " + this.inv.get(0) + " has been fit into the slot.";
        else
            return this.description;
    }
/*----------------------------------------------------------------------------*/
    public void lock() {
        this.searchable = false;
    }
/*----------------------------------------------------------------------------*/
}