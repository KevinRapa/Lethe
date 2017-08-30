package Library;

import A_Main.AudioPlayer;
import static A_Main.Names.LEATHER_SHOES;
import A_Main.Player;
import A_Super.Direction;
import A_Super.Staircase;

public class Lib_Stairs extends Staircase {
/* CONSTRUCTOR ---------------------------------------------------------------*/     
    public Lib_Stairs(Direction dir, String dest) {
        super(dir, dest, 14);
        
        String[] ups = {"second", "up", "northern second-floor"};
        String[] downs = {"first", "down", "southern first-floor"};
        String[] use = (dir == Direction.UP) ? ups : downs;
        
        this.searchDialog = "You begin the search, but as soon as you touch the "
                          + "stairs, they flatten down to the floor before popping "
                          + "back up again.";
        
        this.actDialog = "You successfully climb the stairs to the " + use[0] + " floor.";
        
        this.description = "The stairs are a gray stone with salmon-colored "
                         + "marble steps. They lead " + use[1] + " to the " 
                         + use[2] + " area of the library.";
    }
//-----------------------------------------------------------------------------
    @Override public String interact(String key) {     
        if (Player.getShoes().equals(LEATHER_SHOES)) {
            super.interact(key);
            return this.actDialog;        
        }
        else {
            AudioPlayer.playEffect(40);
            
            switch (this.DIR) {
                case UP:
                    return "As soon as your foot touches the bottom step, the staircase "
                        + "flattens against the floor. You remove your foot, and the "
                        + "staircase pops back up again. 'How irritating!' you exclaim.";
                default:
                    return "As your foot touches the top step, the stairs flatten down "
                            + "against the floor. You jump back and avoid falling to the "
                            + "first floor.";
            }
        }
    }
//-----------------------------------------------------------------------------
}