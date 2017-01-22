package Secret_Stairs;

import A_Super.Room;
/**
 * Superficial, inaccessible without having solved the jade hall lion puzzle.
 * Connects to Jha2 and Sst2.
 * 
 * @see Secret_Stairs.Sst2
 * @see Jade_Hall.Jha2
 * @see Jade_Hall.Jha_Lion
 * @author Kevin Rapa
 */
public class Sst1 extends Room {
// ============================================================================    
    public Sst1(String name, String ID) {
        super(name, ID);
        this.description= "The hidden room looks undeveloped with granite brick\n"
                        + "walls and weathered wood flooring. U-shaped stairs\n"
                        + "wrap around the perimeter of the room up to a third-"
                        + "floor landing.";
    }
// ============================================================================
}