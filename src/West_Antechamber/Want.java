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
                           "the opposite end. Between each pillar is a statue.";
    }
/*----------------------------------------------------------------------------*/        
    @Override public String getBarrier(Direction dir) {
        AudioPlayer.playEffect(6);
        
        if (dir == Direction.WEST)
            return "Oh no! The rotunda is still shifted!";

        return "There is a wall in the way.";
    }
/*----------------------------------------------------------------------------*/
}
