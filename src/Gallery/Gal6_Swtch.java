package Gallery;

import static A_Main.NameConstants.BOX_THINGY;
import A_Super.Furniture;
import A_Super.Lever;
/**
 * This switch turns on the GAL6 cannon if the box thingy is inserted.'
 * 
 * @see Gallery.Gal6_Cnn
 * @author Kevin Rapa
 */        
public class Gal6_Swtch extends Lever {
    private final Gal6_Cnn REF;  
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gal6_Swtch(Furniture cnn) {
        super();
        this.searchDialog = "Nope, this switch isn't hiding anything. But who\n"
                          + "knows when it comes to crazy machinery like this?";
        this.REF = (Gal6_Cnn)cnn; 
        this.addNameKeys("switch", "switch thing");
    }
/*----------------------------------------------------------------------------*/    
    @Override public String event(String key) {
        if (! REF.isOn() && REF.containsItem(BOX_THINGY)) {
            return "You flick the switch.\n" + REF.turnOn();
        }
        else if (REF.isOn()) {
            return "You flick the switch.\n" + REF.turnOff(); 
        }
        else
            return "You flick the switch and nothing happens.";
    }
/*----------------------------------------------------------------------------*/    
}
