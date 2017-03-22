package Kitchen;

import A_Main.GUI;
import A_Main.Inventory;
import A_Main.Player;
import A_Super.Direction;
import A_Super.Room;

public class Kitc extends Room{
    private final Inventory TORCH_INV_REF;
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Kitc(String name, String ID, Inventory torchInv) {
        super(name, ID);
        
        this.TORCH_INV_REF = torchInv;
        this.description = "You have found the kitchen. This room's musty\n" +
                           "odor grows stronger near a pantry on the room's north\n" +
                           "end. A hearth for cooking sits in the room's center\n" +
                           "with pots hanging over it.  Aside the windows on the\n" +
                           "east wall is a shelf of wine and a couple open barrels.\n" +
                           "A counter extends along the west wall, with a metal sink\n"
                         + "on the end closest to you. Mounted on the\n" +
                           "south wall is the key rack mentioned earlier by the\n" +
                           "apparition.";
    }
/*----------------------------------------------------------------------------*/
    @Override public String getBarrier(Direction dir) {
        if ((dir != Direction.WEST) && TORCH_INV_REF.size() == 0)
            return "It's too dark to see anything, and you don't want\n"
                 + "to trip and fall.";
        else 
            return bumpIntoWall();
    }
/*----------------------------------------------------------------------------*/
    @Override public String getDescription() {
        if (TORCH_INV_REF.size() == 0) {
            return "This room is pitch black and fetid. All that's visible is an\n" +
                   "empty mounted holder on the wall next to you and a thin\n" +
                   "slitted window on the east end of the room.";
        }
        return this.description;
    }
/*----------------------------------------------------------------------------*/
    @Override public String triggeredEvent() {
        if (! Player.hasVisited(ID))
            GUI.out("As you step in, a fetid stench immediately infiltrates your senses. "
                  + "You gag a few times before attuning your yourself to the wretched odor.");
            
        return TORCH_INV_REF.size() != 0 ? STD_RM_OUT : "You are in a pitch black room.";
    }
/*----------------------------------------------------------------------------*/
}
