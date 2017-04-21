package Courtyard;
/**
 * @author Kevin Rapa
 */
public class Cou1_Thorns extends Courtyard_Growth {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Cou1_Thorns() {
        super();

        this.description = "It's matted up multiflora rose, an invasive. This "
                         + "stuff is the bane of your career as a lumberjack.";
        this.searchDialog = "You aren't getting pricked by those thorns.";
        this.cutDialog = "You start wacking at the thorns. You start getting pelted in the face with thorns and decide to stop.";
        this.actDialog = "That would probably hurt!";
        this.addNameKeys("thorns?", "(?:matted (?:up )?)?(?:multiflora rose|thorns)");
    }
//-----------------------------------------------------------------------------
}
