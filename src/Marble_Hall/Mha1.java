package Marble_Hall;

import A_Main.GUI;
import A_Super.Room;
import A_Main.Player;
/**
 * Connects to Mha2 and Gal2
 * 
 * @see Gallery.Gal2
 * @see Marble_Hall.Mha2
 * @author Kevin Rapa
 */
public class Mha1 extends Room{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Mha1(String name, String ID) {
        super(name, ID);
    }
//-----------------------------------------------------------------------------
    @Override public String triggeredEvent() {
        if (! Player.hasVisited(this.ID)) {
            GUI.out("As soon as you enter, you catch a glimpse of a white "
                  + "figure passing through a door in the middle of the "
                  + "hallway.");
        }    
        return NAME;
    }
//-----------------------------------------------------------------------------  
}
