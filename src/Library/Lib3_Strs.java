package Library;

import Core.Player;
import Super.Furniture;
import Super.Room;
import Super.Item;
import Core.GUI;

public class Lib3_Strs extends Furniture {
    private final Player REF;
    private final Lib_Shoes REF2;
/* CONSTRUCTOR ---------------------------------------------------------------*/     
    public Lib3_Strs(String NAME, Player plyr, Item shs) {
        super(NAME);
        this.searchable = false;
        this.REF = plyr;
        this.REF2 = (Lib_Shoes)shs;
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
        
        if (REF.doYouHaveIt("leather shoes") && REF2.isWorn()) {
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