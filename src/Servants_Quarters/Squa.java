package Servants_Quarters;

import A_Super.Room;
/**
 * Contains the broken ladder and key to the nearby cabinet.
 * Connects to Sha2
 * 
 * @see Servants_Hall.Sha2
 * @see Servants_Hall.Sha2_Cabinet
 * @author Kevin Rapa
 */
public class Squa extends Room {
/*----------------------------------------------------------------------------*/
    public Squa(String name, String ID) {
        super(name, ID);
        this.description = 
                "You're in a tiny bedroom. With the door closed behind\n" +
                "you, this room feels like a prison cell. Facing west,\n" +
                "you see a plain bed and a wardrobe to your left. Ahead\n" +
                "of you is a barred window. To your right\n" +
                "is a desk with a lit candle on it. You begin\n" +
                "to wonder who keeps all these candles lit.";
    }
/*----------------------------------------------------------------------------*/
}
