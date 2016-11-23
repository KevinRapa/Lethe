package Courtyard;

import Core.Player;
import Super.Staircase;
import Core.GUI;
import Super.Room;

public class Cou3_Stps extends Staircase {
    
    public Cou3_Stps(String NAME, Player player, char direction, int height) {
        super(NAME, player, direction, height);
        this.description = "The long set of crumbling steps climb to a front\n"
                         + "balcony before the castle's great front doors.";
    }
/*----------------------------------------------------------------------------*/
    @Override public String interact(Room[][][] map, String key) {     
        this.REF.setOccupies(map[3][4][5]);
        String rep = "You climb the crumbling steps.";  
        GUI.roomOut(REF.getOcc().triggeredEvent(map));
        REF.describeRoom();
        return rep;
    }
/*----------------------------------------------------------------------------*/
}
