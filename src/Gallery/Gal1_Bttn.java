package Gallery;

import Super.Room;
import Super.Button;
import Super.Furniture;
        
public class Gal1_Bttn extends Button{
    private final Gal1_Drgn REF;
    private boolean isOn;    
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gal1_Bttn(String NAME, Furniture stat) {
        super(NAME);
        this.interactDialog = "You press the button.\n";
        this.REF = (Gal1_Drgn)stat; 
        this.isOn = false;
    }
/*----------------------------------------------------------------------------*/    
    @Override public String interact(Room[][][] map, String key) {
        String rep = this.interactDialog;
        
        this.swtch();
        String rep2 = REF.switchLeft();
        rep += rep2; 

        return rep;
    }   
/*----------------------------------------------------------------------------*/
    private void swtch() {
        this.isOn = ! this.isOn;
    }
/*----------------------------------------------------------------------------*/    
}
