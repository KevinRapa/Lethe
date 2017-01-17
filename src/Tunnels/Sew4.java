package Tunnels;

import A_Super.Furniture;

/**
 * Superficial.
 * Contains a pipe with a missing piece which player must replace.
 * 
 * @see Tunnels.Sew4_Pp
 * @author Kevin Rapa
 */
public class Sew4 extends Dungeon_Tunnel {
    private final Sew4_Pp SEW4_PP;
// ============================================================================    
    public Sew4(String name, String ID, Furniture sew4Pp) {
        super(name, ID);
        this.SEW4_PP = (Sew4_Pp)sew4Pp;
        
        this.description= "The tunnel bends to the north here. The river, following\n" +
                          "the tunnel's north wall, bends with it. A metal pipe\n" +
                          "running along the ceiling above the river follows\n" +
                          "the length of the tunnel northwards and eastwards.";
    }
// ============================================================================
    @Override public String getDescription() {
        if (SEW4_PP.isMissingPipe())
            return this.description.concat(" The pipe has a piece missing...");
        else
            return this.description;
    }
// ============================================================================
}