package West_Antechamber;

import Main.AudioPlayer;
import Super.Room;

public class Want extends Room{
    
    public Want(String name, String ID) {
        super(name, ID);
        this.description = "You are in a wide, two-story hall. The whole room\n" +
                           "is coated in the orange glow of a several torches\n" +
                           "standing around the room. Everything appears to be \n" +
                           "made of sandstone. Looking westward, three pillars \n" +
                           "on each side show the way to a short ramp down on \n" +
                           "the opposite end. A statue fills the spaces between \n" +
                           "each of the pillars.";
    }
/*----------------------------------------------------------------------------*/        
    @Override public String getBarrier(char dir) {
        String rep = "There is a wall in the way.";
        
        if (dir == 'a')
            rep = "Oh no! The rotunda is still shifted!";
        
        AudioPlayer.playEffect(6);
        
        return rep;
    }
/*----------------------------------------------------------------------------*/
}
