package Tunnels;

import A_Super.Furniture;

/**
 * Contains a pipe with a missing piece which player must replace.
 * Connects to Sew3 and Sew5
 * 
 * @see Tunnels.Sew5
 * @see Tunnels.Sew3
 * @see Tunnels.Sew4_Pipe
 * @author Kevin Rapa
 */
public class Sew4 extends Dungeon_Tunnel {
    private final Sew4_Pipe SEW4_PP;
// ============================================================================    
    public Sew4(String name, String ID, Furniture sew4Pp) {
        super(name, ID);
        this.SEW4_PP = (Sew4_Pipe)sew4Pp;
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