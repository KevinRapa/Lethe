package Library;

import Main.Player;
import Super.Furniture;
import Super.Room;
import Main.GUI;

public class Lib3_Strs extends Furniture {
    private final Player REF;
/* CONSTRUCTOR ---------------------------------------------------------------*/     
    public Lib3_Strs(Player plyr) {
        super();
        this.searchable = false;
        this.REF = plyr;
        this.searchDialog = "You begin the search, but as soon as you touch the\n"
                          + "stairs, they flatten down to the floor before popping\n"
                          + "back up again.";
        this.description = "The stairs are a gray stone with salmon-colored\n"
                         + "marble steps. They lead up to the northern second-\n"
                         + "story area of the library.";
        this.addNameKeys("stairs", "staircase", "steps");
        this.addActKeys("use", "climb", "walk");
    }
/*----------------------------------------------------------------------------*/
    @Override public String interact(Room[][][] map, String key) {     
        String rep;
        
        if (REF.shoes().matches("leather shoes")) {
            REF.setOccupies(map[2][1][8]);
                
            rep = "You successfully climb the stairs to the second floor.";
            GUI.roomOut(REF.getOcc().triggeredEvent(map));            
        }
        else {
            rep = "As soon as your foot touches the bottom step, the staircase\n"
                + "flattens against the floor. You remove your foot, and the\n"
                + "staircase pops back up again. 'How irritating!' you exclaim.";
        }
        return rep;
    }
/*----------------------------------------------------------------------------*/
}