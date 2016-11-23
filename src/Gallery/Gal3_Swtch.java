package Gallery;

import Super.Furniture;
        
public class Gal3_Swtch extends Furniture{           
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gal3_Swtch(String NAME) {
        super(NAME);
        this.searchable = false;
        this.description = "It's a small metal switch.";
        this.searchDialog = "Nope, this switch isn't hiding anything.";
        this.interactDialog = "To your displeasure, flicking the switch does nothing.\n"
                    + "'Maybe this pulley mechanism is broken,' you wonder.\n"
                    + "'It wouldn't be the only broken thing in this castle...'";
        this.addActKeys("hit", "flip", "flick", "turn");
        this.addNameKeys("metal switch", "switch");
    }
/*----------------------------------------------------------------------------*/    
}

