package Laboratory;

import A_Main.GUI;
import java.util.TimerTask;
/**
 * @author Kevin Rapa
 */
public class TitrationTask extends TimerTask {
    int volume = 0;
    // ========================================================================  
    @Override public void run() {
        volume += 5;
        GUI.out("Amount dispensed: " + volume + "mL.");
        if (volume == 50)
            this.cancel();
    }
    // ========================================================================  
    public int getVolume() {
        return volume;
    }
    // ========================================================================  
}
