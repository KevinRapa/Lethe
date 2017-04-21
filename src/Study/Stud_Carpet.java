package Study;

import A_Super.Carpet;

public class Stud_Carpet extends Carpet {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Stud_Carpet() {
        super();

        this.description = "A thick red carpet. On top sits the writing desk "
                         + "and chair.";
        this.searchDialog = "To your great curiosity, lifting up the carpet "
                          + "reveals a second identical carpet underneath.";
        
        this.addNameKeys("(?:thick )?(?:red )?(?:carpet|rug)");
    }
//-----------------------------------------------------------------------------
}

