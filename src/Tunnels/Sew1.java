package Tunnels;

import A_Super.Direction;
/**
 * Superficial.
 * 
 * @see Tunnels.Creature_Singleton
 * @author Kevin Rapa
 */
public class Sew1 extends Dungeon_Tunnel {
// ============================================================================    
    public Sew1(String name, String ID) {
        super(name, ID);
        this.description= "You come to a bend in the tunnel. The tunnel turns to\n" +
                          "the south here away from the river of water, which\n" +
                          "continues past the east wall through a barred gate.\n" +
                          "The tunnel leads far back to the west. On the walls\n" +
                          "are several torches lighting the room a dim green hue\n" +
                          "resulting from moss growing everywhere.";
    }
// ============================================================================
    @Override public String getBarrier(Direction dir) {
        switch (dir) {
            case NORTH:
                return "There's a river of water running that way.";
            case EAST:
                return "You can't get the gate open. It's locked.";
            default:
                return bumpIntoWall();
        }
    }
// ============================================================================
}