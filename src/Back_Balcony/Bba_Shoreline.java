package Back_Balcony;

import A_Super.Furniture;

public class Bba_Shoreline extends Furniture{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Bba_Shoreline() {
        super();
        this.description = "It's a long, distant shoreline running in front of " +
                           "the small village.";
        this.searchDialog = "There's no way you are getting over there.";
        this.actDialog = this.searchDialog;
        this.addActKeys("get", "go", "walk", "fly", "jump");
        this.addNameKeys("shore ?(?:line)?");
    }
/*----------------------------------------------------------------------------*/
}
