package Foyer;

import A_Super.Carpet;

public class Foy1_Carpet extends Carpet {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Foy1_Carpet() {
        super();

        this.description = "A thick red carpet. On top sits the large table.";
        this.searchDialog = "To your great curiosity, lifting up the carpet\n"
                          + "reveals a second identical carpet underneath.\n"
                          + "Confused, you leave the carpet alone.";
        this.addNameKeys("(?:thick )?(?:red )?(?:carpet|rug)");
    }
/*----------------------------------------------------------------------------*/
}
