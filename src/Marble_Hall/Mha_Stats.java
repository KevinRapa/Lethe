package Marble_Hall;

import A_Super.Furniture;

public class Mha_Stats extends Furniture {
    private final Furniture REF;
/* CONSTRUCTOR ---------------------------------------------------------------*/     
    public Mha_Stats(Furniture Rstat) {
        super();
        this.REF = Rstat;
        this.searchable = false;
        this.searchDialog = "You aren't sure which one to search. Specify\n"
                          + "'left statue' or 'right statue'";
        this.useDialog = "You aren't sure which one to use it on. Specify\n"
                       + "'left statue' or 'right statue'.";
        this.description = "The pair of statues are mirror images of each other.\n"
                         + "Each leans toward the other while gazing nonchalantly\n"
                         + "towards the ceiling. The only differences are that the\n"
                         + "left statue holds a spear while the right one does not\n"
                         + "and the left statue's base is hollow with an open\n"
                         + "compartment inside. Check out a specific statue by\n"
                         + "specifying 'left statue' or 'right statue'.";
        this.actDialog = "Such impressive works of artistry deserve not to be\n"
                    + "tainted by your touch.";
        this.addNameKeys("statue", "statues");
        this.addActKeys("touch", "grab", "hold");
        this.addUseKeys("silver spear");
    }
/*----------------------------------------------------------------------------*/
    @Override public String getDescription() {
        String rep = this.description;
        
        if (REF.isSearchable()) {
            rep = "The pair af statues are mirror images of each other.\n"
                + "each leans toward the other while gazing nonchalantly\n"
                + "towards the ceiling. They each hold a silver spear\n"
                + "over the other.";
        }      
        return rep;
    }
/*----------------------------------------------------------------------------*/
}
