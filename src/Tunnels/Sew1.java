package Tunnels;

import A_Super.Direction;
/**
 * River here contains pipe piece.
 * Connects to Sew0 and Sew2
 * 
 * @see Tunnels.Sew0
 * @see Tunnels.Sew2
 * @see Tunnels.DungeonMonster
 * @author Kevin Rapa
 */
public class Sew1 extends Dungeon_Tunnel {
// ============================================================================    
    public Sew1(String name, String ID) {
        super(name, ID);
        this.description= 
              "You come to a bend in the tunnel. The tunnel turns " +
              "south here away from the river which continues past "
            + "the east wall through a barred gate. On the walls " +
              "are several torches lighting the room in a dim green hue " +
              "resulting from the rampant moss growth.";
    }
// ============================================================================
    @Override public String getBarrier(Direction dir) {
        switch (dir) {
            case NORTH:
                return WATER_THAT_WAY;
            case EAST:
                return "You can't get the gate open. It's locked.";
            default:
                return bumpIntoWall();
        }
    }
// ============================================================================
}