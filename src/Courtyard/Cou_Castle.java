package Courtyard;

import A_Super.Furniture;
import A_Super.Unmoveable;
/**
 * @author Kevin Rapa
 */
public class Cou_Castle extends Furniture implements Unmoveable {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Cou_Castle() {
        super();

        this.description = "The monstrous castle appears ghastly standing in the "
                         + "night. Scanning it thoroughly, you figure it to be "
                         + "about four or five stories tall. The castle looks to "
                         + "be composed of a central area and a wing on each side.";
        this.searchDialog = "Maybe you should go inside to do that.";
        this.addNameKeys("(?:monstrous )?castle", "portico");
    }
//-----------------------------------------------------------------------------
}

