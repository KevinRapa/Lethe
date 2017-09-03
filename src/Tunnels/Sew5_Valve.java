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
    private final int SEW4PP, SEW2VLVS;
    //-------------------------------------------------------------------------
    public Sew5_Valve (Furniture sew2Vlvs, Furniture sew4Pp) {
        super();
        
        this.SEW2VLVS = sew2Vlvs.getID();
        this.SEW4PP = sew4Pp.getID();
        
        this.description = "The metal valve is connected to a console mounted "
                         + "on the wall next to the door. A smaller pipe coming "
                         + "out the top of the console connects to the larger "
                         + "pipe running through the wall above the door.";
        this.actDialog = "With all your strength, you manage to turn the valve.";

        this.addNameKeys("(?:metal )?valve", "console", "smaller pipe");
        this.addActKeys(VALVEPATTERN);
    }
    //-------------------------------------------------------------------------   
    @Override public String interact(String key) {       
        AudioPlayer.playEffect(17);
        Sew2_Valves v = (Sew2_Valves)Player.getRoomObj(Id.SEW2).getFurnRef(SEW2VLVS);
        Sew4_Pipe p = (Sew4_Pipe)Player.getRoomObj(Id.SEW4).getFurnRef(SEW4PP);
        
        if (! p.isMissingPipe() && v.solved()) {
            ((Cis1)Player.getRoomObj(Id.CIS1)).turnOffGas();
        }
        return this.actDialog;
    }
    //-------------------------------------------------------------------------     
}


