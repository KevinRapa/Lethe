package Workshop;

import A_Super.Room;
/**
 * The player must create a new red lens in this room by combining ingredients
 * in the kiln, then casting it using the casting table and template.
 * 
 * @see Workshop.Wrk_Kiln
 * @see Workshop.Wrk_CastingTable
 * @author Kevin Rapa
 */
public class Work extends Room {
/* CONSTRUCTOR ---------------------------------------------------------------*/      
    public Work(String name, String ID) {
        super(name, ID);
        this.description = "You've found your way into the castle forge. It seems\n" +
                           "to have been converted into a generic\n" +
                           "workshop. It's dry and hot from the heat of the forge. Facing west,\n" +
                           "the centerpiece of this room is the forge in\n" +
                           "the back right corner accompanied by an anvil.\n" +
                           "Closer at the right is a kiln against the wall.\n" +
                           "On the left, a workbench against the wall sits\n" +
                           "below a row of cabinets in front of a window. Next\n" +
                           "to the workbench, closer to you, is a casting table\n" +
                           "and a small wooden barrel.";
    }  
/*----------------------------------------------------------------------------*/        
}
