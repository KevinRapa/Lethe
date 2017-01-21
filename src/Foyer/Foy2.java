package Foyer;

import A_Main.AudioPlayer;
import A_Main.Id;
import A_Main.Player;
import A_Super.Direction;
import A_Super.Room;

public class Foy2 extends Room{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Foy2(String name, String ID) {
        super(name, ID);
    }
/*----------------------------------------------------------------------------*/
    @Override public String getDescription() {
        description = "You stand surrounded by the foyer's immense staircase.\n"
                    + "It curves upwards around you against the back wall for\n"
                    + "two stories. Straight ahead, through an arched way carved\n"
                    + "through the base of the stairs, " + descMode()
                    + " To your right, a statue\n"
                    + "occupies an alcove carved into the wall.";
        
        return description;
    }
/*----------------------------------------------------------------------------*/
    private String descMode() {
        String mode;
        if (! Player.getRoomObj(Id.FOYB).isThisLocked())
            mode = "an open gate leads outside to a balcony.";
        else
            mode = "a closed gate blocks your way outside to a balcony.";
        
        return mode;
    }
/*----------------------------------------------------------------------------*/
    @Override public String getBarrier(Direction dir) {
        if (dir == Direction.NORTH) {
            AudioPlayer.playEffect(4);
            return "The gate that way is closed.";
        }
        else
            return bumpIntoWall();
    }
/*----------------------------------------------------------------------------*/
}
