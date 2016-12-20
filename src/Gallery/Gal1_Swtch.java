package Gallery;

import Super.Room;
import Super.Furniture;
import Super.Lever;
        
public class Gal1_Swtch extends Lever {
    private final Gal1_Drgn REF;    
    /* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gal1_Swtch(Furniture stat) {
        super();
        this.description = "It's a large black lever on the floor";
        this.interactDialog = "You pull the lever.\n";
        this.REF = (Gal1_Drgn)stat; 
        this.addNameKeys("lever", "black lever", "large black lever", "large lever");
    }
/*----------------------------------------------------------------------------*/    
    @Override public String event(Room[][][] map, String key) {
        String rep = this.interactDialog;

        String rep2 = REF.switchRight();
        rep += rep2; 
            
        return rep;
    }   
/*----------------------------------------------------------------------------*/    
}
