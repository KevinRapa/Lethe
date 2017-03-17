package Soul_Chamber;

import A_Super.Room;
/**
 * The player relinquishes all 5 phylacteries here and kills the lich.
 * Connects to Tbal
 * 
 * @see Top_Balcony.Tbal
 * @author Kevin Rapa
 */
public class Soul extends Room {
// ============================================================================    
    public Soul(String name, String ID) {
        super(name, ID);

        this.description= 
                "You have reached the apex point of the castle; a\n" +
                "single chamber suspended high above the sea. The\n" +
                "tall room is arched at the top. Four tall statues\n" +
                "stand at each corner staring down into a pool of\n" +
                "aether in the center. A tall stained-glass window\n" +
                "covers the north wall.";
    }
// ============================================================================   
}
