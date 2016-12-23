package Library;

import A_Main.Player;
import A_Super.Furniture;
import A_Main.GUI;

public class Lib4_Strs extends Furniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/     
    public Lib4_Strs() {
        super();
        this.searchable = false;
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
    @Override public String interact(String key) {     
        String rep;
        
        if (Player.getShoes().matches("leather shoes")) {
            Player.setOccupies(3, 2, 8);
            
            rep = "You climb down the stairs to the first floor.";  
            GUI.roomOut(Player.getOcc().triggeredEvent());
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