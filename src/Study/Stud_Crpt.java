package Study;

import A_Super.Furniture;

public class Stud_Crpt extends Furniture{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Stud_Crpt() {
        super();
        this.searchable = false;
        this.description = "A thick red carpet. On top sits the writing desk\n"
                         + "and chair.";
        this.searchDialog = "To your great curiosity, lifting up the carpet\n"
                          + "reveals a second identical carpet underneath.\n"
                          + "Erik is truly mad.";
        this.addNameKeys("carpet", "rug");
    }
/*----------------------------------------------------------------------------*/
}

