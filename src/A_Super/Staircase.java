package A_Super;

import A_Main.AudioPlayer;
import A_Main.Player;
/**
 * Defines generic attributes and methods for a staircase.
 * @author Kevin Rapa
 */        
abstract public class Staircase extends Furniture 
        implements Unmoveable, Climbable 
{
    protected final Direction DIR; // If it is an up or down staircase.
    protected final int SOUND;
    protected final String DEST;
/* CONSTRUCTOR ---------------------------------------------------------------*/        
    public Staircase(Direction direction, String dest, int sound) {
        super();
        this.DIR = direction;
        this.SOUND = sound;
        this.DEST = dest;
        this.addActKeys(CLIMBPATTERN, "use", "walk", "go");
        this.addNameKeys("stair(?:s|case)|steps?", "banister", "railing");
    }
//-----------------------------------------------------------------------------
    @Override public String interact(String key) {     
        Player.setOccupies(DEST);
        AudioPlayer.playEffect(SOUND);
        return "You climb " + DIR + " the stairs.";
    }
//-----------------------------------------------------------------------------
    @Override public Direction getDir() {
        return DIR;
    }
//-----------------------------------------------------------------------------
}
