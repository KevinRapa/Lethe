package West_Antechamber;

import A_Main.AudioPlayer;
import A_Super.Direction;
import A_Super.Room;

public class Want extends Room {
/*----------------------------------------------------------------------------*/    
    public Want(String name, String ID) {
        super(name, ID);
        this.description = "You are in a wide, two-story hall. The whole room\n" +
                           "is coated in the orange glow of a several torches\n" +
                           "standing around the room. Everything appears to be\n" +
                           "made of sandstone. Looking westward, three pillars\n" +
                           "on each side show the way to an odd door down a short ramp down on\n" +
                           "the opposite end. Between each pillar is a statue. Behind you\n"
                         + "on the wall next to the foyer gate is a small black button.";
    }
/*----------------------------------------------------------------------------*/        
    @Override public String getBarrier(Direction dir) {
        switch (dir) {
            case WEST:
                AudioPlayer.playEffect(6);
                return "The door is missing!";
            case EAST:
                AudioPlayer.playEffect(4);
                return "The gate that way is closed.";
            default:
                return bumpIntoWall();
        }
    }
/*----------------------------------------------------------------------------*/
}
