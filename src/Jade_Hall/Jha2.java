package Jade_Hall;
/**
 * @author Kevin Rapa
 */
import A_Main.Id;
import A_Super.Direction;
import A_Super.Room;

public class Jha2 extends Room {
    private int eyes;
    private final String desc2;
//-----------------------------------------------------------------------------    
    public Jha2(String name, String ID) {
        super(name, ID);

        this.desc2 = "You stand at the south end of the hall near a " +
                     "southern door leading outside. The jade lion at the east "
                   + "stares at the newly formed door on the west wall. A lantern "
                   + "hangs in the center of the ceiling.";
        
        this.eyes = 0;
    }
//-----------------------------------------------------------------------------
    public String lionCheck() {
        if (++eyes == 2) {
            this.addFurniture(new Jha_HiddenDoor(Direction.WEST));
            this.addAdjacent(Id.SST1);
            return " At this moment, you hear a strange noise coming from close "
                 + "behind you. You turn and discover that mysterious door has "
                 + "materialized at the south end of the hallway.";
        }
        return "";
    }
//-----------------------------------------------------------------------------
    @Override public String getDescription() {
        return this.hasFurniture("mysterious door") ? 
                this.desc2 : super.getDescription();
    }
//-----------------------------------------------------------------------------
}