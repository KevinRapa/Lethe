package Marble_Hall;

import A_Main.Player;
import A_Super.Furniture;
/**
 * Resolves ambiguity from there being two statues in this room.
 * 
 * @see Marble_Hall.Mha2_LeftStatue
 * @see Marble_Hall.Mha2_RightStatue
 * @author Kevin Rapa
 */
public class Mha2_Statues extends Furniture {
    private final int R_STAT_ID;
/* CONSTRUCTOR ---------------------------------------------------------------*/     
    public Mha2_Statues(Furniture Rstat) {
        super();
        this.R_STAT_ID = Rstat.getID();

        this.searchDialog = this.useDialog = 
            "You aren't sure which. Specify 'left statue' or 'right statue'";
        
        this.description = "The pair of statues are mirror images of each other. "
                         + "Each leans toward the other while gazing nonchalantly "
                         + "towards the ceiling. The only differences are that the "
                         + "left statue holds a spear while the right one does not "
                         + "and the left statue's base is hollow with an open "
                         + "compartment inside. Choose a specific statue by "
                         + "specifying 'left statue' or 'right statue'.";
        this.actDialog = "Such impressive works of artistry deserve not to be "
                    + "tainted by your touch.";
        this.addNameKeys("(?:angel )?statues?", "angels?", "hands?");
        this.addActKeys(HOLDPATTERN);
        this.addUseKeys(ANYTHING);
    }
//-----------------------------------------------------------------------------
    @Override public String getDescription() {
        if (Player.getPos().getFurnRef(R_STAT_ID).isSearchable()) {
            return "The pair of statues are mirror images of each other. "
                 + "Each leans toward the other while gazing nonchalantly "
                 + "towards the ceiling. They each hold a silver spear "
                 + "over the other.";
        }      
        return this.description;
    }
//-----------------------------------------------------------------------------
}
