package Back_Balcony;

import Super.Furniture;

public class Bba_Wvs extends Furniture{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Bba_Wvs(String NAME) {
        super(NAME);
        this.searchable = false;
        this.description = "The waves crash against a wrecked ship at the cliff's"
                         + "base.";
        this.searchDialog = "If your friends jumped off a cliff, would you too?";
        this.addNameKeys("waves");
    }
/*----------------------------------------------------------------------------*/
}