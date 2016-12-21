package Foyer;

import Main.Player;
import Super.Room;
import Super.Lever;
import Super.Furniture;
        
public class Foy2_Lvr extends Lever{
    private final Foy_Gt REF, REF2;
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Foy2_Lvr(Furniture foy_Gt, Furniture foy2_Gt) {
        super();
        this.searchDialog = "Nope, this hidden lever isn't hiding anything.";
        this.interactDialog = "You pull the lever. The two gates in the foyer switch\n"
                            + "positions.";
        this.REF = (Foy_Gt)foy_Gt; 
        this.REF2 = (Foy_Gt)foy2_Gt;
        this.addNameKeys("small lever", "lever");
    }
/*----------------------------------------------------------------------------*/    
    @Override public String event(String key) {
        Room bba1 = Player.getMapRef()[3][1][5];
        Room want = Player.getMapRef()[3][3][4];

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

        return this.interactDialog;
    } 
/*----------------------------------------------------------------------------*/    
    @Override public String getDescription() {
        description = "A small lever. It's " + (this.isOn ? "on." : "off.");
        return this.description; 
    }
/*----------------------------------------------------------------------------*/    
}
