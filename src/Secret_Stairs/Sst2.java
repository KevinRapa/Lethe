package Secret_Stairs;

import A_Super.Room;
/**
 * Connected to Sst1 and Att2
 * 
 * @see Attic.Att2
 * @see Secret_Stairs.Sst1
 * @author Kevin Rapa
 */
public class Sst2 extends Room {
// ============================================================================    
    public Sst2(String name, String ID) {
        super(name, ID);
        this.description= 
                "You stand at the foot of the steps on a small landing.\n"
                + "Right before you to the east is an old wood door. In\n"
                + "the open on the opposite wall is a vented window\n"
                + "letting in a small amount of moonlight.";
    }
// ============================================================================
}