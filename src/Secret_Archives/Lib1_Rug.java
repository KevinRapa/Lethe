package Secret_Archives;

import A_Super.Carpet;

public class Lib1_Rug extends Carpet {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Lib1_Rug() {
        super();

        this.description = "A dusty Persian rug. Clearly an antique, but it looks "
                         + "surprisingly new.";
        this.searchDialog = "To your great curiosity, lifting up the rug "
                          + "reveals a second identical rug underneath.";
        
        this.addNameKeys("(?:dusty )?(?:persian )?(?:rug|carpet)");
    }
/*----------------------------------------------------------------------------*/
}
