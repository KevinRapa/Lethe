package A_Super;
/**
 * Represents a simple cardinal direction in the game.
 * Used with movement and doors.
 * @author Mantis Toboggan
 */
public enum Direction { 
// ============================================================================
    NORTH("north", 0, -1, 0), 
    SOUTH("south", 0, 1, 0), 
    EAST ("east", 1, 0, 0), 
    WEST ("west", -1, 0, 0), 
    UP   ("up", 0, 0, -1), 
    DOWN ("down", 0, 0, 1);
    
    public final int X, Y, Z; // Positive or negative direction to move in the array.
    private final String ID; // 
// ============================================================================   
    Direction(String id, int x, int y, int z) {
        ID = id;
        X = x;
        Y = y;
        Z = z;
    }
// ============================================================================       
    @Override public String toString() {
        return ID;
    }
// ============================================================================   
}
