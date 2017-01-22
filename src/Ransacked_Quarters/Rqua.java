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
        this.description = "These quarters are a mess. It looks as if someone\n" +
                           "scoured wantonly the entire room in search of\n" +
                           "something. Facing west, a bed and table furnish\n" +
                           "the left of the room. The table is toppled over\n" +
                           "and the mattress is on the floor. On the right is\n" +
                           "a dresser searched thoroughly. Clothes lie scattered\n" +
                           "on the floor. In the opposite wall is a window.";                  
    }
/*----------------------------------------------------------------------------*/
}
