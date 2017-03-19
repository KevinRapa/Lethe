package Tunnels;
/**
 * Serves as a junction between the pool and prison.
 * Connects to Sewp, Pris, Sew2, and Sew4
 * 
 * @see Tunnels.Sew2
 * @see Tunnels.Sew3
 * @see Prison.Pris
 * @see Strange_Pool.Sewp
 * @author Kevin Rapa
 */
public class Sew3 extends Dungeon_Tunnel {
// ============================================================================    
    public Sew3(String name, String ID) {
        super(name, ID);
        this.description= 
              "You are at the junction of a large arched underground tunnel. " +
              "A stone walkway leads west and east following a raging river "
            + "of water against the north wall. A short bridge leads north "
            + "across the river to a door. The river forks here; one half "
            + "curving south down the side tunnel to the pool and the other " +
              "leading further east. A second short bridge to the east gives "
            + "access to the walkway opposite the fork. Running along the "
            + "ceiling is a metal pipe.";
    }
// ============================================================================
}