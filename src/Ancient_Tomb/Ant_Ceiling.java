package Ancient_Tomb;

import A_Super.Ceiling;
/**
 * @author Kevin Rapa
 */
public class Ant_Ceiling extends Ceiling {
    //-------------------------------------------------------------------------
    public Ant_Ceiling () {
        super();
        this.description = "The sandstone brick ceiling arches gently over your head.";
        this.searchDialog = "It's a ceiling...";

        this.addNameKeys("(?:low )?(?:arched )?ceiling");
    }
    //------------------------------------------------------------------------- 
}


