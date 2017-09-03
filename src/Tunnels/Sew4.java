package Tunnels;

import A_Main.Id;
import A_Main.Player;
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
    private final int SEW4_PP;
//-----------------------------------------------------------------------------    
    public Sew4(String name, String ID, Furniture sew4Pp) {
        super(name, ID);
        this.SEW4_PP = sew4Pp.getID();
    }
//-----------------------------------------------------------------------------
    @Override public String getDescription() {
        Sew4_Pipe p = (Sew4_Pipe)Player.getRoomObj(Id.SEW4).getFurnRef(SEW4_PP);
        
        if (p.isMissingPipe())
            return super.getDescription().concat(" The pipe has a gap where a piece is missing...");
        else
            return super.getDescription();
    }
//-----------------------------------------------------------------------------
}