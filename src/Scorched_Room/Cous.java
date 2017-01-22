package Scorched_Room;

import A_Main.AudioPlayer;
import A_Super.Direction;
import A_Super.Room;
/**
 * The player escapes the west wind by knocking down the wall in here with a 
 * warhammer.
 * Haven't been able to invent a story that explains why this room is burnt up.
 * Connects to Clos and Cou2.
 * 
 * @see Scorched_Room.Sear_Fissure
 * @see Closet.Clos
 * @see Courtyard.Cou2
 * @author Kevin Rapa
 */
public class Cous extends Room{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Cous(String name, String ID) {
        super(name, ID);
        description= "This room is horrific! Everything is burned up and\n" +
                     "the floor is coated in ash and chunks of wood.\n" +
                     "Right beside you, against the door, a skeleton lies. \n" +
                     "They were definitely trying to escape this room. There\n"
                   + "is a fissure in the wall to the north.";
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
