package Marble_Hall;

import A_Super.Furniture;
/**
 * Resolves ambiguity from there being two statues in this room.
 * 
 * @see Marble_Hall.Mha2_LeftStatue
 * @see Marble_Hall.Mha2_RightStatue
 * @author Kevin Rapa
 */
public class Mha2_Statues extends Furniture {
    private final Furniture REF;
/* CONSTRUCTOR ---------------------------------------------------------------*/     
    public Mha2_Statues(Furniture Rstat) {
        super();
        this.REF = Rstat;

        this.searchDialog = "You aren't sure which one to search. Specify "
                          + "'left statue' or 'right statue'";
        this.useDialog = "You aren't sure which one to use it on. Specify "
                       + "'left statue' or 'right statue'.";
        this.description = "The pair of statues are mirror images of each other. "
                         + "Each leans toward the other while gazing nonchalantly "
                         + "towards the ceiling. The only differences are that the "
                         + "left statue holds a spear while the right one does not "
                         + "and the left statue's base is hollow with an open "
                         + "compartment inside. Check out a specific statue by "
                         + "specifying 'left statue' or 'right statue'.";
        this.actDialog = "Such impressive works of artistry deserve not to be "
                    + "tainted by your touch.";
        this.addNameKeys("(?:angel )?statues?", "angels?");
        this.addActKeys(HOLDPATTERN);
        this.addUseKeys(ANYTHING);
    }
/*----------------------------------------------------------------------------*/
    @Override public String getDescription() {
        if (REF.isSearchable()) {
            return "The pair af statues are mirror images of each other. "
                 + "each leans toward the other while gazing nonchalantly "
                 + "towards the ceiling. They each hold a silver spear "
                 + "over the other.";
        }      
        return this.description;
    }
/*----------------------------------------------------------------------------*/
}
