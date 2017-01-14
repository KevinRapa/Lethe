package Tunnels;
/**
 * Serves as a junction between the pool and prison.
 * 
 * @author Kevin Rapa
 */
public class Sew3 extends Dungeon_Tunnel {
// ============================================================================    
    public Sew3(String name, String ID) {
        super(name, ID);
        this.description= "You are at the junction of a large arched underground tunnel.\n" +
                          "You stand on a stone walkway extending to the west and east\n" +
                          "following a raging river of water against the north wall.\n" +
                          "A short bridge leads north across the river to a door on the\n" +
                          "other side. The river forks where you stand; one half curving\n" +
                          "south down the side tunnel to the pool and the other half\n" +
                          "leading further down the tunnel to the east. Another short\n" +
                          "bridge to the east gives access to the walkway opposite the\n" +
                          "fork. Mounted on the ceiling is a metal pipe following the\n" +
                          "tunnel.";
    }
// ============================================================================
}