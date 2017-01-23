package Lichs_Quarters;

import A_Super.Furniture;
/**
 * @author Kevin Rapa
 */
public class Lqu1_Mirror extends Furniture {
    // ========================================================================
    public Lqu1_Mirror () {
        super();
        
        this.description = "You look in the mirror, nearly not recognizing\n"
                         + "yourself. You look and feel exhausted and hungry.\n"
                         + "Perhaps, it's only a bit further that you must tread.";

        this.searchDialog = "It's simply a plain mirror.";

        this.addNameKeys("(?:standing )?mirror");
    }
    // ========================================================================     
}


