package Tool_Closet;

import Super.Furniture;
        
public class Gqua_Brrl extends Furniture {

/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gqua_Brrl(String NAME) {
        super(NAME);
        this.description = "It's a cask. You sure hope there's beer in there.";
        this.searchDialog = "You can't get it open. You take a whiff from a\n"
                          + "crack in its surface. Disgusting!!";
        this.interactDialog = "This is way too heavy to move.";
        this.addNameKeys("barrel");
        this.addActKeys("move", "push", "pull");
    }
/*----------------------------------------------------------------------------*/
}
