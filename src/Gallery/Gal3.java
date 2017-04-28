package Gallery;

import A_Super.Furniture;
import A_Super.Room;
/**
 * @author Kevin Rapa
 */
public class Gal3 extends Room {
    private final Gal3_Rope ROPE;
//-----------------------------------------------------------------------------
    public Gal3(String name, String ID, Furniture rope) {
        super(name, ID);
        this.ROPE = (Gal3_Rope)rope;
    }
//-----------------------------------------------------------------------------
    @Override public String getDescription() {
        if (ROPE.isCut()) 
            return super.getDescription()
                    .replaceFirst(" and is suspended above the floor by a rope holding it up", 
                            "");
        else
            return super.getDescription();
    }
//-----------------------------------------------------------------------------  
}