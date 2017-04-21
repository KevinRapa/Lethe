package Library;

import A_Super.Column;

public class Lib_Pillar extends Column {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Lib_Pillar() {
        super();

        this.description = "The fat Corinthian pillar stands in the corner of "
                         + "where the stairs meet the second floor.";

        this.addNameKeys("(?:fat )?(?:corinthian )?(?:pillar|column)");
    }
//-----------------------------------------------------------------------------
}
