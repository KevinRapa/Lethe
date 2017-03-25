package A_Super;

import A_Main.AudioPlayer;
import A_Main.Player;
/**
 * Defines generic attributes and methods for a staircase.
 * @author Kevin Rapa
 */        
abstract public class Staircase extends Furniture implements Unmoveable {
    protected final Direction DIR; // If it is an up or down staircase.
/* CONSTRUCTOR ---------------------------------------------------------------*/        
    public Staircase(Direction direction) {
        super();
        this.DIR = direction;
        this.addActKeys(CLIMBPATTERN, "use", "walk", "go");
        this.addNameKeys("stair(?:s|case)|steps?", "banister", "railing");
    }
/*----------------------------------------------------------------------------*/
    @Override public String interact(String key) {     
        playEffect();
        Player.move(DIR);
        return "You climb " + DIR + " the stairs.";
    }
/*----------------------------------------------------------------------------*/
    protected void playEffect() {
        // For overriding. Some stairs aren't stone.
        AudioPlayer.playEffect(15);
    }
/*----------------------------------------------------------------------------*/
    public Direction getDirection() {
        return DIR;
    }
/*----------------------------------------------------------------------------*/
}
