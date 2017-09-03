package Foyer;

import A_Main.AudioPlayer;
import A_Main.Id;
import A_Main.Player;
import A_Super.Button;
import A_Super.Room;
import A_Super.Furniture;
/**
 * Switches the gates in the foyer
 * 
 * @see Foyer.Foy_Gate
 * @author Kevin Rapa
 */        
public class Foy2_Button extends Button {
    private final int N_GATE_ID, S_GATE_ID;
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Foy2_Button(Furniture foy_Gt, Furniture foy2_Gt) {
        super();
        this.actDialog = "The two gates in the foyer switch positions.";
        this.N_GATE_ID = foy2_Gt.getID();
        this.S_GATE_ID = foy_Gt.getID();
        this.addNameKeys("(?:small )?(?:black )?button");
    }
//-----------------------------------------------------------------------------    
    // Public in order to allow access from FOYW and FOYB.
    @Override public String event(String key) {
        Room bba1 = Player.getRoomObj(Id.FOYB);
        Room want = Player.getRoomObj(Id.FOYW);
        Room foy1 = Player.getRoomObj(Id.FOY1);
        Room foy2 = Player.getRoomObj(Id.FOY2);
        
        if (! want.isAdjacent(Id.FOY1)) {
            want.addAdjacent(Id.FOY1);
            foy1.addAdjacent(Id.FOYW);
            
            foy2.removeAdjacent(Id.FOYB);
            bba1.removeAdjacent(Id.FOY2);
        }
        else {
            want.removeAdjacent(Id.FOY1);
            foy1.removeAdjacent(Id.FOYW);
            
            foy2.addAdjacent(Id.FOYB);
            bba1.addAdjacent(Id.FOY2);
        }
        
        // Opens or closes gate.
        ((Foy_Gate)Player.getRoomObj(Id.FOY2).getFurnRef(N_GATE_ID)).swtch();
        ((Foy_Gate)Player.getRoomObj(Id.FOY1).getFurnRef(S_GATE_ID)).swtch();

        AudioPlayer.playEffect(28);
        
        return this.actDialog;
    } 
//-----------------------------------------------------------------------------    
}