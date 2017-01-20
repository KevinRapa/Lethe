package Library;

import A_Super.Furniture;

public class Lib_Pillar extends Furniture{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Lib_Pillar() {
        super();
        this.searchable = false;
        this.description = "The fat Corinthian pillar stands in the corner of\n"
                         + "where the stairs meet the second floor.";
        this.actDialog = "This pillar doesn't need help holding up the ceiling.";
        this.addNameKeys("(?:fat )?(?:corinthian )?(?:pillar|column)");
        this.addActKeys("hold", "grab");
    }
/*----------------------------------------------------------------------------*/
}
