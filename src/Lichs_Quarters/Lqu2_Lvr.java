package Lichs_Quarters;

import A_Main.AudioPlayer;
import A_Main.Id;
import A_Main.Player;
import A_Super.Lever;
/**
 * @author Kevin Rapa
 */
public class Lqu2_Lvr extends Lever {

    // ========================================================================
    public Lqu2_Lvr () {
        super();
        
        this.description = "A plain lever on the wall.";
        this.actDialog = "With the last of your energy, you pull the lever. You hear a gate open.";

        this.addNameKeys("lever");
    }
    // ========================================================================   
    @Override protected String event(String key) {
        Player.getRoomObj(Id.COU3).addAdjacent(Id.END_);
        Player.getRoomObj(Id.COU3).unlock();
        
        AudioPlayer.playEffect(7, -15);
        
        return this.actDialog;
    }
    // ========================================================================
}


