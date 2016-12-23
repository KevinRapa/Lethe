package Observatory;

import A_Super.Furniture;

public class Obs_Slt extends Furniture {
    private final String CORRECT;
/* CONSTRUCTOR ---------------------------------------------------------------*/      
    public Obs_Slt(String NAME, String correct, String desc) {
            super();
            this.searchable = false;
            this.CORRECT = correct;
            this.description = desc;
            this.searchDialog = "This indentation in the floor is empty."; 
            this.addNameKeys(NAME, NAME.toLowerCase());
    }
/*----------------------------------------------------------------------------*/
    public String getCorrect() {
        return this.CORRECT;
    }
/*----------------------------------------------------------------------------*/
}