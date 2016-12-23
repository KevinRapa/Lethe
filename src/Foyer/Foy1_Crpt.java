package Foyer;

import A_Super.Furniture;

public class Foy1_Crpt extends Furniture{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Foy1_Crpt() {
        super();
        this.searchable = false;
        this.description = "A thick red carpet. On top sits the large table.";
        this.searchDialog = "To your great curiosity, lifting up the carpet\n"
                          + "reveals a second identical carpet underneath.\n"
                          + "Confused, you leave the carpet alone.";
        this.addNameKeys("carpet", "red carpet", "rug", "red rug");
    }
/*----------------------------------------------------------------------------*/
}
