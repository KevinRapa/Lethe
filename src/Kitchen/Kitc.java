package Kitchen;

import A_Main.GUI;
import A_Main.Inventory;
import A_Main.Player;
import A_Super.Direction;
import A_Super.Furniture;
import A_Super.Room;

public class Kitc extends Room{
    private final int TORCH_ID;
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Kitc(String name, String ID, Furniture torchInv) {
        super(name, ID);
        
        this.TORCH_ID = torchInv.getID();
    }
//-----------------------------------------------------------------------------
    @Override public String getBarrier(Direction dir) {
        Inventory i = Player.getPos().getFurnRef(TORCH_ID).getInv();
        
        if ((dir != Direction.WEST) && i.size() == 0)
            return "It's too dark to see anything, and you don't want "
                 + "to trip and fall.";
        else 
            return bumpIntoWall();
    }
//-----------------------------------------------------------------------------
    @Override public String getDescription() {
        Inventory i = Player.getPos().getFurnRef(TORCH_ID).getInv();
        
        if (i.size() == 0) 
            return "This room is pitch black and fetid. All that's visible is an " +
                   "empty mounted holder on the wall next to you and a thin " +
                   "slitted window on the east end of the room.";
        else
            return super.getDescription();
    }
//-----------------------------------------------------------------------------
    @Override public String triggeredEvent() {
        Inventory i = Player.getPos().getFurnRef(TORCH_ID).getInv();
        
        if (! Player.hasVisited(ID))
            GUI.out("As you step in, a fetid stench immediately infiltrates your senses. "
                  + "You gag a few times before attuning your yourself to the wretched odor.");
            
        return i.size() != 0 ? NAME : "Pitch black room";
    }
//-----------------------------------------------------------------------------
}
