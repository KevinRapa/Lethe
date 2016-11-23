package Courtyard;

import Super.Furniture;

public class Cou1_Thrns extends Furniture{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Cou1_Thrns(String NAME) {
        super(NAME);
        this.searchable = false;
        this.description = "It's matted up multiflora rose, an invasive. This\n"
                         + "stuff is the bane of your career as a lumberjack.";
        this.searchDialog = "You aren't getting pricked by those thorns.";
        this.interactDialog = "You aren't getting pricked by those thorns.";
        this.addActKeys("grab", "hold", "touch");
        this.addNameKeys("thorns");
    }
/*----------------------------------------------------------------------------*/
}
