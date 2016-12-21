package Courtyard;

import Super.Staircase;
import Main.GUI;
import Main.Player;

public class Cou3_Stps extends Staircase {
    
    public Cou3_Stps(char direction, int height) {
        super(direction, height);
        this.description = "The long set of crumbling steps climb to a front\n"
                         + "balcony before the castle's great front doors.";
    }
/*----------------------------------------------------------------------------*/
    @Override public String interact(String key) {
        switch(this.DIR) {
            case 'u':
                Player.setOccupies(3,4,5);
                break;
            default:
                Player.setOccupies(3,5,5);
        }
        
        String rep = "You climb " + (DIR == 'u' ? "up" : "down") + " the crumbling steps.";  
        GUI.roomOut(Player.getOcc().triggeredEvent());
        Player.describeRoom();
        return rep;
    }
/*----------------------------------------------------------------------------*/
}
