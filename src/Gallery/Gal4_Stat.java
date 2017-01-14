package Gallery;

import A_Main.Id;
import A_Main.Player;
import A_Super.Furniture;
import A_Super.Statue;

public class Gal4_Stat extends Statue {
    private int level;
    private final Gal7_Stat STAT_REF;
    
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gal4_Stat(Furniture stat) {
        super();
        this.STAT_REF = (Gal7_Stat)stat;
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
    public String activate(char color, boolean isOn) {
        String rep = "The beam of light shines into the central chamber.";
        
        if (Player.getRoomObj(Id.GAL4).hasFurniture("statue") && isOn && this.level != 3) {
            
            if ((color == 'b' && this.level == 0) || 
                (color == 'g' && this.level == 1) || 
                (color == 'w' && this.level == 2)) {
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
        else if (Player.getRoomObj(Id.GAL4).hasFurniture("statue") && this.level == 3 && isOn)
            rep = "The beam of light shines at the statue's base.";
        
        return rep;
    }     
/*----------------------------------------------------------------------------*/
    private String raise() {
        switch (level++) {
            case 0: 
                return "The crystal orb in the statue's palm glows blue.";
            case 1: 
                return "The orb's glow turns green and it begins to hum.";
            default: 
                Player.getRoomObj(Id.GAL7).addFurniture(STAT_REF);
                return "The crystal orb's glow brightens to a blinding white\n"
                    + "light. It hums loudly and rises once again to the\n"
                    + "third floor level.";
        }
    }
/*----------------------------------------------------------------------------*/
    @Override public String getDescription() {
        String rep = this.description;
        
        switch(this.level) {
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
            default:
        }
        return rep;
    }
/*----------------------------------------------------------------------------*/
}

