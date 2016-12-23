package Back_Balcony;

import A_Super.Furniture;

public class Bba_Shrln extends Furniture{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Bba_Shrln() {
        super();
        this.searchable = false;
        this.description = "It's a long, distant shoreline running in front of\n" +
                           "the small village.";
        this.searchDialog = "There's no way you are getting over there.";
        this.addNameKeys("shore", "shoreline", "shore line");
    }
/*----------------------------------------------------------------------------*/
}
