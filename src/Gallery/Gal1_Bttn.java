package Gallery;

import A_Super.Button;
import A_Super.Furniture;
        
public class Gal1_Bttn extends Button {
    private final Gal1_Drgn REF;
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gal1_Bttn(Furniture stat) {
        super();
        this.actDialog = "You press the button. ";
        this.REF = (Gal1_Drgn)stat; 
    }
/*----------------------------------------------------------------------------*/    
    @Override public String event(String key) {
        return this.actDialog + REF.switchLeft();
    }   
/*----------------------------------------------------------------------------*/
}
