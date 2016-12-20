package Gallery;

import Main.AudioPlayer;
import Main.Player;
import Super.Staircase;

public class Gal6_Lddr extends Staircase {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gal6_Lddr(Player player, char direction, int height) {
        super(player, direction, height);
        this.searchDialog = "The ladder hides nothing.";
        this.description = "The ladder leads down the hatch into the room below.";
    }
/*----------------------------------------------------------------------------*/
    @Override protected void playEffect() {
        // For overriding. Some stairs aren't wooden.
        AudioPlayer.playEffect(16);
    }
}
