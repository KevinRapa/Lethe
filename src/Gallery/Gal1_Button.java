package Gallery;

import A_Super.Button;
import A_Super.Furniture;
/**
 * One of two object which turn on the GAL1 Dragon
 * 
 * @see Gallery.Gal1_Dragon
 * @see Gallery.Gal1_Switch
 * @author Kevin Rapa
 */
public class Gal1_Button extends Button {
    private final Gal1_Dragon REF;
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gal1_Button(Furniture stat) {
        super();
        this.actDialog = "You press the button. ";
        this.REF = (Gal1_Dragon)stat; 
    }
//-----------------------------------------------------------------------------    
    @Override public String event(String key) {
        return this.actDialog.concat(REF.switchEye(0));
    }   
//-----------------------------------------------------------------------------
}
