package Observatory;

import A_Super.Statue;

public class Obs_Stat extends Statue {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Obs_Stat(String NAME, String desc, int position) {
        super();
        this.description = desc;
        this.NAMEKEYS.clear();
        this.addNameKeys(NAME);
    }
/*----------------------------------------------------------------------------*/
}
