package Back_Balcony;

import A_Super.Furniture;
/**
 * @author Kevin Rapa
 */
public class Bba_Cliff extends Furniture{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Bba_Cliff() {
        super();
        this.description = "The cliff has a steep incline. To your discomfort,\n"
                         + "you spot an eerie body in a pocket of rocks on it.";
        this.searchDialog = "You aren't jumping down there like that last person\n"
                          + "did.";
        this.addNameKeys("cliff", "drop");
    }
/*----------------------------------------------------------------------------*/
}