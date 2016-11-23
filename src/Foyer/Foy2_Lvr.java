package Foyer;

import Super.Room;
import Super.Furniture;
        
public class Foy2_Lvr extends Furniture{
    private final Foy_Gt REF, REF2;
    private boolean isOn;
    private boolean found;
    private String state;
            
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Foy2_Lvr(String NAME, Furniture foy_Gt, Furniture foy2_Gt) {
        super(NAME);
        this.searchable = false;
        this.searchDialog = "Nope, this hidden lever isn't hiding anything.";
        this.REF = (Foy_Gt)foy_Gt; 
        this.REF2 = (Foy_Gt)foy2_Gt;
        this.found = false;
        this.isOn = false;
        this.addActKeys("pull", "push", "flick", "hit");
        this.addNameKeys("small lever", "lever");
    }
/*----------------------------------------------------------------------------*/    
    @Override public String interact(Room[][][] map, String key) {
        Room bba1 = map[3][1][5];
        Room want = map[3][3][4];
        
        if (this.found) {
            this.swtch();

            if (this.isOn) {
                want.unlock();
                bba1.lock();
            }
            else {
                want.lock();
                bba1.unlock();
            }
            REF.swtch();
            REF2.swtch();
            return "You pull the lever. The two gates in the foyer switch\n"
                 + "positions."; 
        }
        else
            return "There is no lever in this room.";
    }
    
/*----------------------------------------------------------------------------*/    
    @Override public String getDescription() {
        if (this.found) {
            state = this.isOn ? "on." : "off.";  
            description = "A small lever. It's " + state;
            return this.description; 
        }
        else
            return "There is no lever in this room.";
    }
    
/*----------------------------------------------------------------------------*/
@Override public String getSearchDialog() {
        if (this.found)
            return this.searchDialog;
        else
            return "There is no lever in this room";
    }
/*----------------------------------------------------------------------------*/    
    public void discover() {
        this.found = true;
    }
    
/*----------------------------------------------------------------------------*/
    private void swtch() {
        this.isOn = ! this.isOn;
    }
/*----------------------------------------------------------------------------*/    
}
