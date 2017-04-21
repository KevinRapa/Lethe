package Library;

import A_Main.AudioPlayer;
import A_Main.Id;
import static A_Main.Names.LEATHER_SHOES;
import A_Main.Player;
import A_Super.Direction;
import A_Super.Staircase;

public class Lib3_Stairs extends Staircase {
/* CONSTRUCTOR ---------------------------------------------------------------*/     
    public Lib3_Stairs() {
        super(Direction.UP);
        this.searchDialog = "You begin the search, but as soon as you touch the "
                          + "stairs, they flatten down to the floor before popping "
                          + "back up again.";
        this.actDialog = "You successfully climb the stairs to the second floor.";
        this.description = "The stairs are a gray stone with salmon-colored "
                         + "marble steps. They lead up to the northern second- "
                         + "story area of the library.";
    }
//-----------------------------------------------------------------------------
    @Override public String interact(String key) {     
        if (Player.getShoes().equals(LEATHER_SHOES)) {
            this.playEffect();
            Player.setOccupies(Id.LIB4);
            return this.actDialog;        
        }
        else {
            AudioPlayer.playEffect(40);
            return "As soon as your foot touches the bottom step, the staircase "
                 + "flattens against the floor. You remove your foot, and the "
                 + "staircase pops back up again. 'How irritating!' you exclaim.";
        }
    }
//-----------------------------------------------------------------------------
    @Override public void playEffect() {
        AudioPlayer.playEffect(14);
    }
//-----------------------------------------------------------------------------
}