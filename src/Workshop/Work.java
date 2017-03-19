package Workshop;

import A_Super.Room;
/**
 * The player must create a new red lens in this room by combining ingredients
 * in the kiln, then casting it using the casting table and template.
 * The key to this room is found in a safe in the Secret Archives.
 * Connects to Eow4.
 * 
 * @see Secret_Archives.Lib1_Safe
 * @see East_Outer_Wall.Eow4
 * @see Workshop.Wrk_Kiln
 * @see Workshop.Wrk_CastingTable
 * @author Kevin Rapa
 */
public class Work extends Room {
/* CONSTRUCTOR ---------------------------------------------------------------*/      
    public Work(String name, String ID) {
        super(name, ID);
        this.description = 
               "You've found your way into a smithy, dry and hot, which has been "
             + "converted into a generic workshop. In the northeast corner is "
             + "the forge accompanied by an anvil. Closer by is a kiln against "
             + "the wall. At the south, a workbench against the wall sits below "
             + "a row of cabinets in front of a window. Next to the workbench, "
             + "closer to you, is a casting table and a small wooden barrel.";
    }  
/*----------------------------------------------------------------------------*/        
}
