package Library;

import Main.Player;
import Super.Furniture;
import Super.Room;
import Main.GUI;

public class Lib4_Strs extends Furniture {
    private final Player REF;
/* CONSTRUCTOR ---------------------------------------------------------------*/     
    public Lib4_Strs(Player plyr) {
        super();
        this.searchable = false;
        this.REF = plyr;
        this.searchDialog = "You begin the search, but as soon as you touch the\n"
                          + "stairs, they flatten down to the floor before popping\n"
                          + "back up again.";
        this.description = "The stairs are a gray stone with salmon-colored\n"
                         + "marble steps. They lead down to the first-floor\n"
                         + "library.";
        this.addNameKeys("staircase", "stairs", "steps");
        this.addActKeys("use", "climb", "walk");
    }
/*----------------------------------------------------------------------------*/
    @Override public String interact(Room[][][] map, String key) {     
        String rep;
        
        if (REF.shoes().matches("leather shoes")) {
            REF.setOccupies(map[3][2][8]);
            
            rep = "You climb down the stairs to the first floor.";  
            GUI.roomOut(REF.getOcc().triggeredEvent(map));
        }
        else {
            rep = "As your foot touches the top step, the stairs flatten down\n"
                + "causing you to fall to the first floor. 'Should have worn\n"
                + "those shoes, dammit.'";
        }
        return rep;
    }
/*----------------------------------------------------------------------------*/
}