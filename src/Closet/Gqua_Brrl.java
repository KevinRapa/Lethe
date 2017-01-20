package Closet;

import A_Super.Furniture;
import A_Super.Openable;
/**
 * @author Kevin Rapa
 */
public class Gqua_Brrl extends Furniture implements Openable {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gqua_Brrl() {
        super();
        this.description = "It's a cask. You sure hope there's beer in there.";
        this.searchDialog = "You can't get it open. You take a whiff from a\n"
                          + "crack in its surface. Disgusting!!";
        this.actDialog = "This is way too heavy to move.";
        this.addNameKeys("barrel", "cask");
        this.addActKeys("move", "push", "pull");
    }
/*----------------------------------------------------------------------------*/
}
