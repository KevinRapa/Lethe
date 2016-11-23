package Gallery;

import Super.Furniture;
import Super.Room;

public class Gal_2E_Stat extends Furniture{
    private int level;
    private final Room REF;
    private final Room REF2;
    private final Gal_3E_Stat REF3;
    
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gal_2E_Stat(String NAME, Room gal7, Room gal4, Furniture stat) {
        super(NAME);
        this.searchable = false;
        this.REF = gal7;
        this.REF2 = gal4;
        this.REF3 = (Gal_3E_Stat)stat;
        this.level = 0;
        this.description = "The statue now stands surrounded by the second floor\n"
                         + "balcony. Its orb has stopped glowing, though one of\n"
                         + "its eyes has started to.";        
        this.searchDialog = "The statue's hand is out of reach";
        this.addNameKeys("statue");
    }
/*----------------------------------------------------------------------------*/
    public int getState() {
        return this.level;
    }
/*----------------------------------------------------------------------------*/
    public String activate(char color, Gal3_Ttm ttm) {
        String rep = "The beam of light shines into the central chamber.";
        
        if (REF2.hasFurniture(this.NAME) && ttm.isOn() && this.level != 3) {
            
            if (color == 'b' && this.level == 0) {
                rep = this.raise(); 
            }        
            else if (color == 'g' && this.level == 1) {
                rep = this.raise(); 
            }        
            else if (color == 'w' && this.level == 2) {
                rep = this.raise(); 
            }       
            else if (this.level == 0) {
                rep = "The beam of light shines into the orb with no effect.";
            }
            else if (this.level == 1 || this.level == 2) {
                rep = "The orb's hum dies and its glow fades.";
                this.level = 0;
            }
        }
        else if (REF2.hasFurniture(this.NAME) && this.level == 3 && ttm.isOn())
            rep = "The beam of light shines at the statue's base.";
        
        return rep;
    }     
/*----------------------------------------------------------------------------*/
    private String raise() {
        String rep;
        this.level++; 
        
        switch (this.level) {
            
        case 0: 
            rep = "The crystal orb in the statue's palm glows blue.";
            break;
        case 1: 
            rep = "The orb's glow turns green and it begins to hum.";
            break;
        default: 
            REF.addFurniture(REF3);
            rep = "The crystal orb's glow brightens to a blinding white\n"
                + "light. It hums loudly and rises once again to the\n"
                + "third floor level.";
        }
        return rep;  
    }
/*----------------------------------------------------------------------------*/
    @Override public String getDescription() {
        String rep = this.description;
        
        switch(this.level) {
            case 0:
                break;
            case 1:
                rep = "The statue stands holding the glowing orb. It hums softly."; 
                break;
            case 2:
                rep = "The statue stands holding the glowing orb. It's humming\n"
                    + "quite loudly now."; 
                break;
            case 3:
                rep = "The statue has risen yet again to the highest area of\n"
                    + "the central chamber across from the third floor loft.\n"
                    + "The statue's plinth is now exceedingly long and unusual.";
        }
        return rep;
    }
/*----------------------------------------------------------------------------*/
}

