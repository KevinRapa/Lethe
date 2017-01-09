package A_Super;

import A_Main.AudioPlayer;
import A_Main.GUI;
import A_Main.Player;
/**
 * Defines generic attributes and methods for a staircase.
 * @author Kevin Rapa
 */        
public class Staircase extends Furniture {
    protected final Direction DIR; // If it is an up or down staircase.
    protected final int HT; // How many levels this moves the player.
/* CONSTRUCTOR ---------------------------------------------------------------*/        
    public Staircase(Direction direction, int height) {
        super();
        this.searchable = false;
        this.DIR = direction;
        this.HT = height;
        this.addActKeys("climb", "use", "walk");
        this.addNameKeys("stair(?:s|case)|steps");
    }
/*----------------------------------------------------------------------------*/
    @Override public String interact(String key) {     
        int[] c = Player.getPos().getCoords();

        playEffect();
        Player.setOccupies(c[0] + DIR.Z, c[1], c[2]);
        
        return "You climb " + DIR + " the stairs.";
    }
/*----------------------------------------------------------------------------*/
    protected void playEffect() {
        // For overriding. Some stairs aren't wooden.
        AudioPlayer.playEffect(15);
    }
/*----------------------------------------------------------------------------*/
}
