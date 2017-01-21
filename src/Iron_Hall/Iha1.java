package Iron_Hall;

import A_Main.AudioPlayer;
import A_Super.Direction;
import A_Super.Room;

public class Iha1 extends Room {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Iha1(String name, String ID) {
        super(name, ID);
        description= "You are on the dark north end of a long hallway. It resembles\n" +
                     "the antechamber you were in previously. Looking to the\n" +
                     "south, the hallway extends to a door on the other side. On\n" +
                     "your end looking south, a suit of armor on your right is\n" +
                     "displayed opposite an open barred window to your left. In its gauntlet\n"
                   + "is a polearm. Hanging above is an unlit steel bowl. It looks\n" +
                     "like it's supposed to be lighting this end of the hallway.\n"
                   + "Behind you, aside the door, is a black iron lever.";
    }
/*----------------------------------------------------------------------------*/    
    @Override public String getBarrier(Direction dir) {
        if (dir == Direction.NORTH) {
            AudioPlayer.playEffect(6);
            return "The door is missing!";
        }
        else
            return bumpIntoWall(); 
    }
/*----------------------------------------------------------------------------*/
}
