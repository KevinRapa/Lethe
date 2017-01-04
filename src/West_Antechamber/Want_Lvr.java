package West_Antechamber;

import A_Main.AudioPlayer;
import A_Super.Lever;
import A_Main.Player;
import Rotunda.Rotu;

public class Want_Lvr extends Lever {
    public Want_Lvr() {
        super();
        this.searchable = false;
        this.description = "It's a black iron lever resting on the plinth of the\n"
                         + "statue.";
        this.searchDialog = "There's a pile of gold! No, not really, just a lever.";
        this.actDialog = "You pull the lever. The room you are in vibrates and you\n"
                    + "here a prolonged rumble past the wall to your west.";
        this.addNameKeys("lever", "(?:black )?(?:iron )?lever");
    }
/*----------------------------------------------------------------------------*/    
    @Override public String event(String key) {
        Rotu ref = (Rotu)Player.getRoomRef("ROTU");
        
        if (ref.getState() == 'e')
            return "You pull the lever, but nothing happens except a faint\n"
                 + "-click- sounding past the wall to your west.";
        else {
            AudioPlayer.playEffect(19);
            ref.rotate();
        }
        return this.actDialog;
    }
/*----------------------------------------------------------------------------*/
}
