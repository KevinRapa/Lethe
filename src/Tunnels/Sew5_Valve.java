package Tunnels;

import A_Main.AudioPlayer;
import A_Main.Id;
import A_Main.Player;
import A_Super.Furniture;
import Cistern.Cis1;
/**
 * Disperses the gas in CIS1 if the valve puzzle in SEW2 has been solved.
 * 
 * @see Cistern.Cis1
 * @see Tunnels.Sew2_Valves
 * @author Kevin Rapa
 */
public class Sew5_Valve extends Furniture {
    private final Sew4_Pipe SEW4PP;
    private final Sew2_Valves SEW2VLVS;
    // ========================================================================
    public Sew5_Valve (Furniture sew2Vlvs, Furniture sew4Pp) {
        super();
        
        this.SEW2VLVS = (Sew2_Valves)sew2Vlvs;
        this.SEW4PP = (Sew4_Pipe)sew4Pp;
        
        this.description = "The metal valve is connected to a console mounted\n"
                         + "on the wall next to the door. A smaller pipe coming\n"
                         + "out the top of the console connects to the larger\n"
                         + "pipe running through the wall above the door.";
        this.actDialog = "With all your strength, you manage to turn the valve.";

        this.addNameKeys("(?:metal )?valve", "console", "smaller pipe");
        this.addActKeys(VALVEPATTERN);
    }
    // ========================================================================   
    @Override public String interact(String key) {       
        AudioPlayer.playEffect(17);
        
        if (! SEW4PP.isMissingPipe() && SEW2VLVS.solved()) {
            ((Cis1)Player.getRoomObj(Id.CIS1)).turnOffGas();
        }
        return this.actDialog;
    }
    // ========================================================================     
}


