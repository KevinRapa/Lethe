package Back_Balcony;

import Super.Furniture;

public class Bba_Clff extends Furniture{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Bba_Clff(String NAME) {
        super(NAME);
        this.searchable = false;
        this.description = "The cliff has a steep incline. To your discomfort,\n"
                         + "you spot an eerie body in a pocket of rocks on it.";
        this.searchDialog = "You aren't jumping down there like that last person\n"
                          + "did.";
        this.addNameKeys("cliff");
    }
/*----------------------------------------------------------------------------*/
}