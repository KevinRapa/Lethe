package Foyer;

import Super.Furniture;

public class Foy2_Alc extends Furniture{
    Foy2_Stat ref;
    
    public Foy2_Alc(String NAME, Furniture foy2Stat) {
        super(NAME);
        this.ref = (Foy2_Stat)foy2Stat;
        this.searchable = false;
        this.description = "A shallow domed alcove carved into the wall.\n"
                         + "A statue displays itself inside of it.";
        this.searchDialog = "The large statue makes searching difficult. You\n"
                          + "can't seem to find anything.";
        this.addNameKeys("alcove");
    }
    /*----------------------------------------------------------------------------*/    
    @Override public String getDescription() {
        if (! ref.getState())                     
            return this.description;
        else
            return "A shallow domed alcove carved into the wall. Behind\n"
                 + "the displaced statue is a small lever.";
    }
    
/*----------------------------------------------------------------------------*/
    @Override public String getSearchDialog() {
        if (! ref.getState())
            return this.searchDialog;
        else
            return "With the statue moved, you see a small lever in the back.";
    }
/*----------------------------------------------------------------------------*/
}
