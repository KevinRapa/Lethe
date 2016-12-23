package Gallery;

import A_Super.Furniture;
import A_Super.Lever;
        
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
        if (! REF.isOn() && REF.doesThisHaveIt("box thingy")) {
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
