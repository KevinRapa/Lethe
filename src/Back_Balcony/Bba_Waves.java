package Back_Balcony;

import A_Super.Furniture;

public class Bba_Waves extends Furniture{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Bba_Waves() {
        super();
        this.searchable = false;
        this.description = "The waves crash against a wrecked ship at the cliff's"
                         + "base.";
        this.searchDialog = "If your friends jumped off a cliff, would you too?";
        this.addNameKeys("waves");
    }
/*----------------------------------------------------------------------------*/
}