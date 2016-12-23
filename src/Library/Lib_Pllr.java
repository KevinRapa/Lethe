package Library;

import A_Super.Furniture;

public class Lib_Pllr extends Furniture{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Lib_Pllr() {
        super();
        this.searchable = false;
        this.description = "The fat Corinthian pillar stands in the corner of\n"
                         + "where the stairs meet the second floor.";
        this.actDialog = "This pillar doesn't need help holding up the ceiling.";
        this.addNameKeys("pillar", "corinthian pillar", "column");
        this.addActKeys("hold", "grab");
    }
/*----------------------------------------------------------------------------*/
}
