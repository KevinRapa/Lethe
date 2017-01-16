package Lichs_Quarters;

import A_Super.Furniture;
/**
 * @author Kevin Rapa
 */
public class Lqu1_Mrrr extends Furniture {
    // ========================================================================
    public Lqu1_Mrrr () {
        super();
        this.searchable = false;
        
        this.description = "You look in the mirror, nearly not recognizing\n"
                         + "yourself. You look and feel exhausted and hungry.\n"
                         + "Perhaps, it's only a bit further that you must tread.";

        this.searchDialog = "It's simply a plain mirror.";

        this.addNameKeys("(?:standing )?mirror");
    }
    // ========================================================================     
}


