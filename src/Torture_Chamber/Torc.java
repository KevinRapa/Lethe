package Torture_Chamber;

import static A_Main.Names.SCYTHE;
import A_Main.Player;
import A_Super.Room;
/**
 * Holds a metal ladder that the player needs to replace the pipe in SEW4 and
 * a scythe for the statue in the crypt.
 * Connects to Cry1 and Pris
 * 
 * @see Prison.Pris
 * @see Crypt.Cry1
 * @author Kevin Rapa
 */
public class Torc extends Room {
//-----------------------------------------------------------------------------    
    public Torc(String name, String ID) {
        super(name, ID);
    }
//-----------------------------------------------------------------------------
    @Override public String getDescription() {
        if (! Player.getPos().hasFurniture(SCYTHE))
            return this.description.replaceFirst(" below a large scythe", "");
        else
            return this.description;
    }
//-----------------------------------------------------------------------------
}
