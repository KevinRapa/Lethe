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
    private final Foy_Gate NORTH_GATE_REF, SOUTH_GATE_REF;
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Foy2_Button(Furniture foy_Gt, Furniture foy2_Gt) {
        super();
        this.actDialog = "The two gates in the foyer switch positions.";
        this.NORTH_GATE_REF = (Foy_Gate)foy_Gt; 
        this.SOUTH_GATE_REF = (Foy_Gate)foy2_Gt;
        this.addNameKeys("(?:small )?(?:black )?button");
    }
/*----------------------------------------------------------------------------*/    
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
        NORTH_GATE_REF.swtch(); // Opens or closes gate.
        SOUTH_GATE_REF.swtch(); // Opens or closes gate.

        AudioPlayer.playEffect(28);
        
        return this.actDialog;
    } 
/*----------------------------------------------------------------------------*/    
}