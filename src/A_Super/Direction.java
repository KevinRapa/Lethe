package A_Super;
/**
 * Represents a simple direction in the game.
 * Used with movement and doors.
 * 
 * @author Kevin Rapa
 */
public enum Direction { 
//-----------------------------------------------------------------------------
    NORTH("north", 0, -1, 0), 
    SOUTH("south", 0, 1, 0), 
    EAST ("east", 1, 0, 0), 
    WEST ("west", -1, 0, 0), 
    UP   ("up", 0, 0, -1), 
    DOWN ("down", 0, 0, 1),
    NE   ("northeast", 0, 0, 0), 
    NW   ("northwest", 0, 0, 0), 
    SE   ("southeast", 0, 0, 0), 
    SW   ("southwest", 0, 0, 0);
    
    public final int X, Y, Z; // Positive or negative direction to move in the array.
    private final String ID; // String representation of the direction. 
//-----------------------------------------------------------------------------   
    Direction(String id, int x, int y, int z) {
        ID = id;
        X = x;
        Y = y;
        Z = z;
    }
//-----------------------------------------------------------------------------       
    @Override public String toString() {
        return ID;
    }
//-----------------------------------------------------------------------------   
}
