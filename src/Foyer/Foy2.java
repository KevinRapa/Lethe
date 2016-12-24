package Foyer;

import A_Main.Player;
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
        if (! Player.getRoomRef("FOYB").isThisLocked())
            mode = "an open gate leads\noutside to a balcony.";
        else
            mode = "a closed gate blocks\nyour way outside to a balcony.";
        
        return mode;
    }
/*----------------------------------------------------------------------------*/
}
