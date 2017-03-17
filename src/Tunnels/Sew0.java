package Tunnels;

/**
 * Hallway in which the monster walks.
 * Contains staircase up to DST1.
 * Connects to Sew1
 * 
 * @see Tunnels.Sew2
 * @see Tunnels.DungeonMonster
 * @see Dungeon_Stairs.Dst1
 * @author Kevin Rapa
 */
public class Sew0 extends Dungeon_Tunnel {
// ============================================================================    
    public Sew0(String name, String ID) {
        super(name, ID);
        this.description= 
                "The tunnel terminates here at a spiral staircase\n" +
              "leading upwards. Behind you to the north, the river of water\n" +
              "continues through the barred arched opening in the\n" +
              "wall eastwards. A couple torches on the walls light this end\n" +
              "of the tunnel.";
    }
// ============================================================================
}