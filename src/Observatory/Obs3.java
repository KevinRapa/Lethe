package Observatory;

import A_Main.AudioPlayer;
import A_Super.Direction;
import A_Super.Room;

public class Obs3 extends Room {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Obs3(String name, String ID) {
        super(name, ID);
        description= "You have made your way to the highest area of the observatory.\n" +
                     "Here, a balcony follows the large multistory window around\n" +
                     "the perimeter of the room from the north to the south wall.\n" +
                     "A large chandelier hangs in the center over a two-story drop.\n" +
                     "Two telescopes stand on opposite sides of the balcony facing\n" +
                     "different directions. You can see a chest on the far side of\n" +
                     "the balcony.";
    }
/*----------------------------------------------------------------------------*/   
    @Override public String getBarrier(Direction dir) {
        if (dir == Direction.EAST)
            return "The balcony railing is that way.";
        
        AudioPlayer.playEffect(6);
        return "There is a wall in the way.";
    }
/*----------------------------------------------------------------------------*/
}
