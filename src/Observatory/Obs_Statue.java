package Observatory;

import A_Super.Statue;
/**
 * Furniture type for the observatory statue puzzle.
 * 
 * @see Observatory.Obs_Stats
 * @author Kevin Rapa
 */
public class Obs_Statue extends Statue {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Obs_Statue(String NAME, String desc, int position) {
        super();
        this.description = desc;
        this.NAMEKEYS.clear();
        this.addNameKeys(NAME);
    }
/*----------------------------------------------------------------------------*/
}
