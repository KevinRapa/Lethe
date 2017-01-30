package Back_Hall;

import A_Super.Item;
import A_Super.PottedPlant;
/**
 * @author Kevin Rapa
 */
public class Bha1_Plant extends PottedPlant { 
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Bha1_Plant(Item soil) {
        super(soil);

        this.description = "The plant doesn't seem to be in good shape. Though\n"
                         + "drooping a bit, it's still alive.";
    }
/*----------------------------------------------------------------------------*/
}