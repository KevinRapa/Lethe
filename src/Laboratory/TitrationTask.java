package Laboratory;

import A_Main.GUI;
import java.util.Timer;
import java.util.TimerTask;
/**
 * Allows player to select a specific number, representing volume of a titrated
 * chemical, incremented by 5 every 2.5 seconds in a thread.
 * 
 * @author Kevin Rapa
 */
public class TitrationTask extends TimerTask {
    private static int volume = 0;
    //-------------------------------------------------------------------------  
    @Override public void run() {
        volume += 5;
        GUI.out("Amount dispensed: " + volume + "mL.");
        if (volume == 50)
            this.cancel();
    }
    //-------------------------------------------------------------------------  
    public static int titrate() {
        Timer timer = new Timer(true);
        TitrationTask task = new TitrationTask();
        timer.schedule(task, 0, 2500);
        
        GUI.promptOut();
        
        task.cancel();
        timer.purge();
        
        int result = volume;
        volume = 0;
        
        return result;
    }
    //-------------------------------------------------------------------------  
}
