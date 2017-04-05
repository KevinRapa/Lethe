package Cellar;

import A_Main.AudioPlayer;
import A_Main.Player;
import A_Super.Climbable;
import A_Super.Direction;
import A_Super.Furniture;
/**
 * @author Kevin Rapa
 */
public class Cel_Ladder extends Furniture implements Climbable {
    private final String DEST;
    private final Direction DIR;
    // ========================================================================
    public Cel_Ladder (String ID, Direction dir) {
        super();
        
        this.DIR = dir;
        this.DEST = ID;
        
        this.description = "It's a metal ladder with rudimentary rungs attached "
                         + "directly to the stone wall.";
        this.actDialog = "You climb " + dir + " the long ladder.";

        this.addNameKeys("(?:metal )?ladder", "rungs?");
        this.addActKeys("use", dir.toString(), CLIMBPATTERN);
    }
    // ========================================================================   
    @Override public String interact(String key) {      
        AudioPlayer.playEffect(47);
        Player.setOccupies(DEST);
        return this.actDialog;
    }
    // ========================================================================     
    @Override public Direction getDir() {
        return DIR;
    }
    // ========================================================================  
}


