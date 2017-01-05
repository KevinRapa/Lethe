package Foyer;

import A_Super.Furniture;

public class Foy2_Alc extends Furniture{
    private final Foy2_Stat STAT_REF;
    public Foy2_Alc(Furniture foy2Stat) {
        super();
        this.STAT_REF = (Foy2_Stat)foy2Stat;
        this.searchable = false;
        this.description = "A shallow domed alcove carved into the wall.\n"
                         + "A statue displays itself inside of it.";
        this.searchDialog = "The large statue makes searching difficult. You\n"
                          + "can't seem to find anything.";
        this.addNameKeys("(?:shallow )?(?:domed )?alcove");
    }
    /*----------------------------------------------------------------------------*/    
    @Override public String getDescription() {
        if (! STAT_REF.moved())                     
            return this.description;
        else
            return "A shallow domed alcove carved into the wall. Behind\n"
                 + "the displaced statue is a small lever.";
    }
    
/*----------------------------------------------------------------------------*/
    @Override public String getSearchDialog() {
        if (! STAT_REF.moved())
            return this.searchDialog;
        else
            return "With the statue moved, you see a small lever in the back.";
    }
/*----------------------------------------------------------------------------*/
}
