package Iron_Hall;

import A_Main.AudioPlayer;
import A_Super.Direction;
import A_Super.Room;

public class Iha1 extends Room {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Iha1(String name, String ID) {
        super(name, ID);
        description= 
                "You are on the dark north end of a long hall resembling " +
                "the antechamber you were in previously. The hallway extends "
              + "southwards to a door on the other side. A suit of armor on "
              + "the west wall is displayed opposite an open barred window "
              + "to your left. In its gauntlet is a polearm. Hanging above "
              + "is an unlit steel bowl. It looks like it's supposed to be "
              + "lighting this end of the hall. Behind you, aside the door, "
              + "is an iron lever.";
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
