package Foyer;

import A_Main.AudioPlayer;
import A_Main.Id;
import A_Main.Player;
import A_Super.Room;
import A_Super.Lever;
import A_Super.Furniture;
/**
 * Switches the gates in the foyer
 * 
 * @see Foyer.Foy_Gate
 * @author Kevin Rapa
 */        
public class Foy2_Lever extends Lever{
    private final Foy_Gate REF, REF2;
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Foy2_Lever(Furniture foy_Gt, Furniture foy2_Gt) {
        super();
        this.searchDialog = "Nope, this hidden lever isn't hiding anything.";
        this.actDialog = "You pull the lever. The two gates in the foyer switch\n"
                            + "positions.";
        this.REF = (Foy_Gate)foy_Gt; 
        this.REF2 = (Foy_Gate)foy2_Gt;
        this.addNameKeys("(?:small )?(?:hidden )?lever");
    }
/*----------------------------------------------------------------------------*/    
    @Override public String event(String key) {
        Room bba1 = Player.getRoomObj(Id.FOYB);
        Room want = Player.getRoomObj(Id.FOYW);
        
        if (this.isOn) {
            want.unlock();
            bba1.lock();
        }
        else {
            want.lock();
            bba1.unlock();
        }
        REF.swtch(); // Opens or closes gate.
        REF2.swtch(); // Opens or closes gate.

        AudioPlayer.playEffect(28);
        
        return this.actDialog;
    } 
/*----------------------------------------------------------------------------*/    
    @Override public String getDescription() {
        description = "A small lever. It's " + (this.isOn ? "on." : "off.");
        return this.description; 
    }
/*----------------------------------------------------------------------------*/    
}
