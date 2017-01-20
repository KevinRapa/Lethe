package Courtyard;

import A_Super.Furniture;
/**
 * @author Kevin Rapa
 */
public class Cou1_Thrns extends Furniture{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Cou1_Thrns() {
        super();
        this.searchable = false;
        this.description = "It's matted up multiflora rose, an invasive. This\n"
                         + "stuff is the bane of your career as a lumberjack.";
        this.searchDialog = "You aren't getting pricked by those thorns.";
        this.actDialog = "You aren't getting pricked by those thorns.";
        this.addActKeys("grab", "hold", "touch");
        this.addNameKeys("thorns", "(?:matted (?:up )?)?(?:multiflora rose|thorns)");
    }
/*----------------------------------------------------------------------------*/
}
