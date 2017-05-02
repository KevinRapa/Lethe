package Forest;

import A_Super.Furniture;
/**
 * @author Kevin Rapa
 */
public class For_Thicket extends Furniture {

    //-------------------------------------------------------------------------
    public For_Thicket () {
        super();
        
        this.description = "Just unsightly brambles. Definitely not relevent to "
                + "the plot in any way.";
        this.searchDialog = "There's absolutely nothing there.";

        this.addNameKeys("(?:impenetrable )?thicket", "(?:unsightly )?brambles");
    }
    //-------------------------------------------------------------------------
}


