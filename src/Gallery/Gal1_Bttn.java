package Gallery;

import Super.Room;
import Super.Button;
import Super.Furniture;
        
public class Gal1_Bttn extends Button{
    private final Gal1_Drgn REF;
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gal1_Bttn(Furniture stat) {
        super();
        this.interactDialog = "You press the button.\n";
        this.REF = (Gal1_Drgn)stat; 
    }
/*----------------------------------------------------------------------------*/    
    @Override public String event(Room[][][] map, String key) {
        String rep = this.interactDialog;
        
        String rep2 = REF.switchLeft();
        rep += rep2; 

        return rep;
    }   
/*----------------------------------------------------------------------------*/
}
