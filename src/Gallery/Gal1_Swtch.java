package Gallery;

import Super.Room;
import Super.Furniture;
        
public class Gal1_Swtch extends Furniture{
    private final Gal1_Drgn REF;
    private boolean isOn;
            
    /* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gal1_Swtch(String NAME, Furniture stat) {
        super(NAME);
        this.searchable = false;
        this.description = "It's a large black lever on the floor";
        this.interactDialog = "You pull the lever.\n";
        this.REF = (Gal1_Drgn)stat; 
        this.isOn = false;
        this.addActKeys("pull", "push", "flick", "hit", "move");
        this.addNameKeys("lever");
    }
/*----------------------------------------------------------------------------*/    
    @Override public String interact(Room[][][] map, String key) {
        String rep = this.interactDialog;
        
        this.swtch();
        String rep2 = REF.switchRight();
        rep += rep2; 
            
        return rep;
    }   
/*----------------------------------------------------------------------------*/
    private void swtch() {
        this.isOn = ! this.isOn;
    }
/*----------------------------------------------------------------------------*/    
}
