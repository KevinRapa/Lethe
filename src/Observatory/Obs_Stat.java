package Observatory;

import Super.Furniture;

public class Obs_Stat extends Furniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Obs_Stat(String NAME, String desc, int position) {
        super(NAME);
        this.searchable = false;
        this.description = desc;
    }
/*----------------------------------------------------------------------------*/
}
