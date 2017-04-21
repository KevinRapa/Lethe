package Back_Balcony;

import A_Super.Column;

public class Bba_Columns extends Column {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Bba_Columns() {
        super();
        this.description = "The granite columns are wide and bulging.";
        this.addNameKeys("(?:granite )?(?:columns?|pillars?)");
    }
//-----------------------------------------------------------------------------
}