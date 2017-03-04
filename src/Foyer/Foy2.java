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
        this.description = "You stand surrounded by the foyer's immense staircase.\n"
                    + "It curves upwards around you against the back wall for\n"
                    + "two stories. Straight ahead, through an arched way carved\n"
                    + "through the base of the stairs, %"
                    + " To your right, a statue\n"
                    + "occupies an alcove carved into the wall.";
    }
/*----------------------------------------------------------------------------*/
    @Override public String getDescription() {
        return description.replaceFirst("%", descMode());
    }
/*----------------------------------------------------------------------------*/
    private String descMode() {       
        return Player.getPos().isAdjacent(Id.FOYB) ? 
                "an opened gate leads into another room." :
                "a closed gate blocks your way into another room.";                                               
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
