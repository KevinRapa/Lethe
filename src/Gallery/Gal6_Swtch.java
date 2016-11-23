package Gallery;

import Super.Room;
import Super.Furniture;
        
public class Gal6_Swtch extends Furniture {
    private final Gal6_Cnn REF;
    private boolean isOn;          
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gal6_Swtch(String NAME, Furniture cnn) {
        super(NAME);
        this.searchable = false;
        this.searchDialog = "Nope, this switch isn't hiding anything. But who\n"
                          + "knows when it comes to crazy machinery like this?";
        this.REF = (Gal6_Cnn)cnn; 
        this.isOn = false;
        this.addActKeys("flick", "hit", "flip", "turn");
        this.addNameKeys("electronic canon", "electric canon", "canon");
    }
/*----------------------------------------------------------------------------*/    
    @Override public String interact(Room[][][] map, String key) {
        String rep;
        
        this.swtch();
        if (! REF.isOn() && REF.doesThisHaveIt("box thingy")) {
            rep =  "You flick the switch.\n" + REF.turnOn();
        }
        else if (REF.isOn()) {
            rep =  "You flick the switch.\n" + REF.turnOff(); 
        }
        else
            rep = "You flick the switch and nothing happens.";
        
        return rep;
    }
/*----------------------------------------------------------------------------*/
    private void swtch() {
        this.isOn = ! this.isOn;
    }
/*----------------------------------------------------------------------------*/    
}
