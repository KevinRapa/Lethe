package Escape_Tunnel;

import A_Main.AudioPlayer;
import A_Main.Id;
import A_Main.Player;
import A_Super.Climbable;
import A_Super.Furniture;
/**
 * @author Kevin Rapa
 */
public class Esc1_Ladder extends Furniture implements Climbable {
    // ========================================================================
    public Esc1_Ladder () {
        super();
        
        this.description = "It's a metal ladder with rudimentary rungs attached\n"
                         + "directly to the stone wall.";
        this.actDialog = "You climb back up the ladder.";

        this.addNameKeys("(?:metal )?ladder", "rungs?");
        this.addActKeys("use", "climb", "ascend");
    }
    // ========================================================================   
    @Override public String interact(String key) {      
        AudioPlayer.playEffect(47);
        Player.setOccupies(Id.INTR);
        return this.actDialog;
    }
    // ========================================================================     
}


