package Gallery;

import A_Super.Furniture;
import A_Super.Lever;
/**
 * One of two object which turn on Gal1 Dragon
 * 
 * @see Gallery.Gal1_Drgn
 * @see Gallery.Gal1_Bttn
 * @author Kevin Rapa
 */        
public class Gal1_Swtch extends Lever {
    private final Gal1_Drgn DRAGON_REF;    
    /* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gal1_Swtch(Furniture stat) {
        super();
        this.description = "It's a large black lever on the floor";
        this.actDialog = "You pull the lever. ";
        this.DRAGON_REF = (Gal1_Drgn)stat; 
        this.addNameKeys("(?:large )?(?:black )?lever");
    }
/*----------------------------------------------------------------------------*/    
    @Override public String event(String key) {
        return this.actDialog.concat(DRAGON_REF.switchEye(1));
    }   
/*----------------------------------------------------------------------------*/    
}
