package Courtyard;

import Main.Player;
import Super.Staircase;
import Main.GUI;
import Super.Room;

public class Cou3_Stps extends Staircase {
    
    public Cou3_Stps(Player player, char direction, int height) {
        super(player, direction, height);
        this.description = "The long set of crumbling steps climb to a front\n"
                         + "balcony before the castle's great front doors.";
    }
/*----------------------------------------------------------------------------*/
    @Override public String interact(Room[][][] map, String key) {
        switch(this.DIR) {
            case 'u':
                this.REF.setOccupies(map[3][4][5]);
                break;
            default:
                this.REF.setOccupies(map[3][5][5]);
        }
        
        String rep = "You climb " + (DIR == 'u' ? "up" : "down") + " the crumbling steps.";  
        GUI.roomOut(REF.getOcc().triggeredEvent(map));
        REF.describeRoom();
        return rep;
    }
/*----------------------------------------------------------------------------*/
}
