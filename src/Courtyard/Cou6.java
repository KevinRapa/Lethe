package Courtyard;

import A_Main.AudioPlayer;
import A_Super.Direction;
import A_Super.Room;
/**
 * Contains the ghost that plays blackjack.
 * 
 * @see Courtyard.Cou6_BlackJackGhost
 * @author Kevin Rapa
 */
public class Cou6 extends Room {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Cou6(String name, String ID) {
        super(name, ID);
        description= "You're in the northeast section of the courtyard,\n" +
                     "on the right side of the great set of steps. This\n" +
                     "area is mostly overgrown with thorns. In the center\n" +
                     "of this area is a crumbling statue. You can also barely\n" +
                     "make out a ruined stone bench hiding beneath the thorny\n" +
                     "growth. This area is just a nook beside the great set of\n" +
                     "steps and appears to lead nowhere. You look to your right\n" +
                     "and spot an ghostly apparition leaning against the castle wall.";
    }
/*----------------------------------------------------------------------------*/
    @Override public String getBarrier(Direction dir) {
        if (dir == Direction.WEST) {
            AudioPlayer.playEffect(6);
            return "You'll need to climb the steps to get up there.";
        }
        if (dir == Direction.NORTH || dir == Direction.EAST)
            return "There's too much thorny growth to go anywhere else.";
        else 
            return bumpIntoWall();
    }
/*----------------------------------------------------------------------------*/
}