package Library;

import Core.Player;
import Super.Furniture;
import Super.Room;
import Super.Item;
import Core.GUI;

public class Lib4_Strs extends Furniture {
    private final Player REF;
    private final Lib_Shoes REF2;
/* CONSTRUCTOR ---------------------------------------------------------------*/     
    public Lib4_Strs(String NAME, Player plyr, Item shs) {
        super(NAME);
        this.searchable = false;
        this.REF = plyr;
        this.REF2 = (Lib_Shoes)shs;
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
        
        REF.setOccupies(map[3][2][8]);
    
        if (REF.doYouHaveIt("leather shoes") && REF2.isWorn()) {
            rep = "You climb down the stairs to the first floor.";              
        }
        else {
            rep = "As your foot touches the top step, the stairs flatten down\n"
                + "causing you to fall to the first floor. 'Should have worn\n"
                + "those shoes, dammit.'";
        }
        GUI.roomOut(REF.getOcc().triggeredEvent(map));
        
        return rep;
    }
/*----------------------------------------------------------------------------*/
}