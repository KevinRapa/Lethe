package Gallery;

import A_Super.Furniture;
import A_Super.Room;
import A_Super.Statue;

public class Gal_2E_Stat extends Statue {
    private int level;
    private final Room GAL7_REF;
    private final Room GAL4_REF;
    private final Gal_3E_Stat STAT_REF;
    
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gal_2E_Stat(Room gal7, Room gal4, Furniture stat) {
        super();
        this.GAL7_REF = gal7;
        this.GAL4_REF = gal4;
        this.STAT_REF = (Gal_3E_Stat)stat;
        this.level = 0;
        this.actDialog = "The statue is out of reach";
        this.description = "The statue now stands surrounded by the second floor\n"
                         + "balcony. Its orb has stopped glowing, though one of\n"
                         + "its eyes has started to.";        
        this.searchDialog = "The statue's hand is out of reach";
    }
/*----------------------------------------------------------------------------*/
    public int getState() {
        return this.level;
    }
/*----------------------------------------------------------------------------*/
    public String activate(char color, Gal3_Ttm ttm) {
        String rep = "The beam of light shines into the central chamber.";
        
        if (GAL4_REF.hasFurniture("statue") && ttm.isOn() && this.level != 3) {
            
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
        else if (GAL4_REF.hasFurniture("statue") && this.level == 3 && ttm.isOn())
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
            GAL7_REF.addFurniture(STAT_REF);
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

