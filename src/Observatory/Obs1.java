package Observatory;

import A_Super.Room;
/**
 * Holds the observatory statue puzzle, solved to obtain the ruby for the jade hall.
 * 
 * @see Observatory.Obs_Stats
 * @see Jade_Hall.Jha_Ln
 * @author Kevin Rapa
 */
public class Obs1 extends Room{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Obs1(String name, String ID) {
        super(name, ID);
        description= "You stand in the castle's grandiose three-story observatory.\n" +
                     "A many-paned window extends up all three on the west side,\n" +
                     "and a balcony wraps against the window on the\n"
                   + "third level. A spiral staircase\n" +
                     "in a southeast nook lead up one level. This\n" +
                     "room is dominated by a ring of statues in the center, each\n" +
                     "resembling a Greek diety. On the floor at the base of each is a brass slot.\n"
                   + "Against the east wall is an old telescope, most likely nonfunctional.\n" +
                     "A long curved seat sits in front of the window on the\n" +
                     "west end next to a globe and standing lamp.";
    }
/*----------------------------------------------------------------------------*/   
}
