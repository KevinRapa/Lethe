package Front_Balcony;

import Core.Player;
import Super.Staircase;
import Core.GUI;
import Super.Room;

public class Entr_Stps extends Staircase {
    
    public Entr_Stps(String NAME, Player player, char direction, int height) {
        super(NAME, player, direction, height);
        this.description = "The long set of crumbling steps climb down to the\n"
                         + "courtyard.";
        this.searchDialog = "You find nothing.";
    }
/*----------------------------------------------------------------------------*/
    @Override public String interact(Room[][][] map, String key) {     
        this.REF.setOccupies(map[3][5][5]);
        String rep = "You climb down the crumbling steps.";  
        GUI.roomOut(REF.getOcc().triggeredEvent(map));
        REF.describeRoom();
        
        return rep;
    }
/*----------------------------------------------------------------------------*/
}
