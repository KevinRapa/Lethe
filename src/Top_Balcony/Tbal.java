package Top_Balcony;

import A_Super.Room;
import A_Super.Direction;
/**
 * @author Kevin Rapa
 */
public class Tbal extends Room {
// ============================================================================    
    public Tbal(String name, String ID) {
        super(name, ID);
        this.description= "You are on an outside balcony before a set of\n" +
                          "stairs leading to a solemn chamber to the north.\n" +
                          "The chamber is a small building with a simple\n" +
                          "gabled roof perched on a pillar extending all the\n" +
                          "way to the sea far below.";
    }
// ============================================================================
    @Override public String getBarrier(Direction dir) {
        return "The balcony railing is that way. It's a long drop to the sea.";
    }
// ============================================================================
}