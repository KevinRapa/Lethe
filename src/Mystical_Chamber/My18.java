package Mystical_Chamber;
/**
 * @author Kevin Rapa
 */
import A_Super.Room;

public class My18 extends Room {
// ============================================================================    
    public My18(String name, String ID) {
        super(name, ID);
        this.description= "You found your way to a circlular chamber with a low,\n" +
                          "domed ceiling. There is nothing in this room except\n" +
                          "for a pedestal standing in the center and a hanging\n" +
                          "bowl of fire above it.";
    }
// ============================================================================
    public void updateDescription() {
        this.description = "You stand at the rim of the circular chamber before\n"
                         + "the descending set of spiral stairs wrapping around\n"
                         + "the center pillar on which the pedestal still stands.\n";
    }
// ============================================================================
}