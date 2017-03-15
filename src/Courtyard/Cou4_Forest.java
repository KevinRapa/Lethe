package Courtyard;

import A_Super.Furniture;
/**
 * @author Kevin Rapa
 */
public class Cou4_Forest extends Furniture{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Cou4_Forest() {
        super();

        this.description = "All you can see is an endless dark expanse of trees.";
        this.searchDialog = "You have no intention of turning back now.";
        this.actDialog = "That's your trade, you know. But it's too late for logging now.";
        this.addActKeys("chop", "cut", "log");
        this.addNameKeys("forest", "trees?");
    }
/*----------------------------------------------------------------------------*/    
}
