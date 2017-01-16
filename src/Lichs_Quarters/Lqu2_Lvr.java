package Lichs_Quarters;

import static A_Main.AudioPlayer.S;
import static A_Main.AudioPlayer.WD;
import A_Main.Id;
import A_Main.Player;
import A_Super.Lever;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
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
        
        try {
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(new File(WD, "effects" + S + "gateSlam.wav")));

            ((FloatControl)clip.getControl(FloatControl.Type.MASTER_GAIN))
                    .setValue(-15);

            clip.start();
        } catch (LineUnavailableException | UnsupportedAudioFileException | 
                 IOException ex) {
            System.out.println(ex.getMessage());
        }
        
        return this.actDialog;
    }
    // ========================================================================
}


