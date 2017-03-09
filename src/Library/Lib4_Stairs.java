package Library;

import A_Main.AudioPlayer;
import A_Main.Player;
import A_Main.Id;
import static A_Main.NameConstants.LEATHER_SHOES;
import A_Super.Direction;
import A_Super.Staircase;

public class Lib4_Stairs extends Staircase {
/* CONSTRUCTOR ---------------------------------------------------------------*/     
    public Lib4_Stairs() {
        super(Direction.DOWN);
        this.searchDialog = "You begin the search, but as soon as you touch the\n"
                          + "stairs, they flatten down to the floor before popping\n"
                          + "back up again.";
        this.description = "The stairs are a gray stone with salmon-colored\n"
                         + "marble steps. They lead down to the first-floor\n"
                         + "library.";
        this.actDialog = "You climb down the stairs to the first floor.";
        this.addNameKeys("staircase", "stairs", "steps");
        this.addActKeys("use", CLIMBPATTERN, "walk");
    }
/*----------------------------------------------------------------------------*/
    @Override public String interact(String key) {     
        if (Player.getShoes().equals(LEATHER_SHOES)) {
            Player.setOccupies(Id.LIB3);
            this.playEffect();
            return this.actDialog;  
        }
        else {
            AudioPlayer.playEffect(40);
            return "As your foot touches the top step, the stairs flatten down\n"
                 + "against the floor. You jump back and avoid falling to the\n"
                 + "first floor.";
        }
    }
/*----------------------------------------------------------------------------*/
    @Override public void playEffect() {
        AudioPlayer.playEffect(14);
    }
/*----------------------------------------------------------------------------*/
}