package Gallery;

import A_Super.Lever;
        
public class Gal3_Switch extends Lever {           
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gal3_Switch() {
        super();
        
        this.description = "It's a small metal switch.";
        this.actDialog = "To your displeasure, flicking the switch does nothing. "
                    + "'Maybe this pulley mechanism is broken,' you wonder. "
                    + "'It wouldn't be the only broken thing in this castle...'";

        this.addNameKeys("(?:metal )?switch");
    }
//-----------------------------------------------------------------------------    
    @Override protected String event(String key) {
        return this.actDialog;
    }
//-----------------------------------------------------------------------------
}

