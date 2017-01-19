package Courtyard;

import A_Main.Id;
import A_Super.Staircase;
import A_Main.Player;
import A_Super.Direction;

public class Cou3_Stps extends Staircase {
/*----------------------------------------------------------------------------*/    
    public Cou3_Stps(Direction direction, int height) {
        super(direction, height);
        this.description = "The long set of crumbling steps climb to a front\n"
                         + "balcony before the castle's great front doors.";
    }
/*----------------------------------------------------------------------------*/
    @Override public String interact(String key) {
        // Moves the player diagonally and up.
        switch(this.DIR) {
            case UP:
                Player.setOccupies(Id.COU7);
                break;
            default:
                Player.setOccupies(Id.COU3);
        }
        playEffect();
        
        return "You climb " + DIR + " the crumbling steps.";  
    }
/*----------------------------------------------------------------------------*/
}
