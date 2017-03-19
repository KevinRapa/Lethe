package Observatory;

import A_Super.Room;
/**
 * Holds the observatory statue puzzle, solved to obtain the ruby for the jade hall.
 * Connects to Bha1 and Obs2
 * 
 * @see Observatory.Obs2
 * @see Back_Hall.Bha1
 * @see Observatory.Obs_Stats
 * @see Jade_Hall.Jha_Ln
 * @author Kevin Rapa
 */
public class Obs1 extends Room{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Obs1(String name, String ID) {
        super(name, ID);
        description= 
                "You stand in a three-story observatory. A humongous window "
              + "to west extends all the way up. A spiral staircase in a "
              + "southeast nook leads up to a balcony. This room is dominated "
              + "by a ring of statues, each resembling a diety. On the floor "
              + "at the base of each is a brass slot. Against the east wall "
              + "is an old telescope, likely nonfunctional. A long curved "
              + "seat sits in front of the window on the west end next to a "
              + "globe and standing lamp.";
    }
/*----------------------------------------------------------------------------*/   
}
