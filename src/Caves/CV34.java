package Caves;

import A_Super.Furniture;

/**
 * Contains a well which is related to story.
 * Connects to catacombs.
 * 
 * @see Catacombs.Catacomb
 * @author Kevin Rapa
 */
public class CV34 extends Cave {
//-----------------------------------------------------------------------------    
    public CV34(String name, String ID, Furniture wall, Furniture ceiling) {
        super(ID, wall, ceiling);
        this.descUnlit = "You've found your way to an open area... There's something "
                       + "in the center. It feels stone, round and empty "
                       + "in the center.";
        this.descLit += "This area is more open and circular than "
                      + "the rest of the cave. A round well stands "
                      + "in the center.";
    }
//-----------------------------------------------------------------------------
}