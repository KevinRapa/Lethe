package Lichs_Quarters;

import A_Super.Furniture;
/**
 * @author Kevin Rapa
 */
public class Lqu1_Bed extends Furniture {
    //-------------------------------------------------------------------------
    public Lqu1_Bed () {
        super();

        this.description = "On the far side of the room, a sinister body "
                         + "lays on a bed. Perhaps not much longer.";
        this.actDialog = "Really? That's a terrible idea.";
        this.searchDialog = "It's too far away to do that.";

        this.addNameKeys("body", "bed", "lich");
        this.addActKeys(SITPATTERN);
    }
    //-------------------------------------------------------------------------    
}


