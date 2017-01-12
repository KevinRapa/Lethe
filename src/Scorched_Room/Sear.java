package Scorched_Room;

import A_Main.AudioPlayer;
import A_Super.Direction;
import A_Super.Room;

public class Sear extends Room{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Sear(String name, String ID) {
        super(name, ID);
        description= "This room is horrific! Everything is burned up and\n" +
                     "the floor is coated in ash and chunks of wood.\n" +
                     "Right beside you, against the door, a skeleton lies. \n" +
                     "They were definitely trying to escape this room. There\n"
                   + "is an interesting fissure in the wall to the north.";
    }
/*----------------------------------------------------------------------------*/
    @Override public String getBarrier(Direction dir) {
        switch (dir) {
            case WEST:
                AudioPlayer.playEffect(6);
                return "The door here is boarded up.";
            case NORTH:
                return "You're too stocky to fit through the fissure.";
            default:
                return bumpIntoWall();
        }
    }
/*----------------------------------------------------------------------------*/
}
