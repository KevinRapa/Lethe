package Ransacked_Quarters;

import A_Super.Room;
/**
 * Accessed by using the battering ram on the door in the adjacent room.
 * Contains the study key under a panel.
 * Connects to Sha1.
 * 
 * @see Servants_Hall.Sha1
 * @see Ransacked_Quarters.Rqua_Panel.
 * @author Kevin Rapa
 */
public class Rqua extends Room{
/*----------------------------------------------------------------------------*/   
    public Rqua(String name, String ID) {
        super(name, ID);
        this.description = 
                "These servants quarters are a mess. Facing west, a "
              + "bed and table furnish the left of the room. The "
              + "table is toppled over and the mattress is on the "
              + "floor. On the right is a dresser searched thoroughly. "
              + "Clothes and linens lie scattered on the floor. Under "
              + "a window on the west wall sits an apparent elderly "
              + "woman. She looks at you with an open stare and crazy "
              + "grin while she laughs quietly to herself.";                  
    }
/*----------------------------------------------------------------------------*/
}
