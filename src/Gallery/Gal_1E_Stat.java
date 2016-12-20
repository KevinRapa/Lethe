package Gallery;

import Super.Furniture;
import Super.Item;
import Super.Room;
import Main.Inventory;

public class Gal_1E_Stat extends Furniture {
    private int level;
    private final Room REF;
    private final Inventory REF2;
    private final Gal_2E_Stat REF3;
    
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gal_1E_Stat(Room gal4, Inventory inv, Furniture stat) {
        super();
        this.REF = gal4;
        this.REF2 = inv;
        this.REF3 = (Gal_2E_Stat)stat;
        this.level = 0;
        this.description = "The grandiose statue stands in the exact center of\n"
                         + "the circular room. It portrays a male figure. He\n"
                         + "poises elegantly, with his right arm extended over\n"
                         + "his head and left hand held low as if bearing an\n"
                         + "object, though it's empty.";        
        this.searchDialog = "The statue's hand is empty";
        this.addNameKeys("statue");
        this.addUseKeys("crystal orb");
        this.inv = new Stat_Inv(this);
    }
/*----------------------------------------------------------------------------*/
    public int getState() {
        return this.level;
    }
/*----------------------------------------------------------------------------*/
    public String activate(char color, Gal1_Drgn drgn) {
        String rep = "The orb sits comfortably in the statue's palm.";
        
        if (this.doesThisHaveIt("crystal orb") && drgn.isOn() && this.level != 3) {
            
            if (color == 'r' && this.level == 0) {
                rep = this.raise(); 
            }        
            else if (color == 'p' && this.level == 1) {
                rep = this.raise(); 
            }        
            else if (color == 'P' && this.level == 2) {
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
        else if (! this.doesThisHaveIt("crystal orb") && drgn.isOn())
            rep = "The beam of light shines at the statue in the central chamber.";
        
        else if (this.level == 3 && drgn.isOn())
            rep = "The beam shines at the statue's risen plinth.";
        
        return rep;
    }    
/*----------------------------------------------------------------------------*/
    private String raise() {
        String rep;
        this.level++;
        
        switch (this.level) {
            
        case 0:
            rep = "The crystal orb in the statue's palm begins to glow red.";
            break;
        case 1: 
            rep = "The orb starts to hum louder and its glow turns purple.";
            break;         
       default:
            this.searchable = false;
            REF.addFurniture(REF3);
            rep = "The orb's glow turns a dark purple before fading into\n"
                + "ultraviolet. The statue raises on its platform to the\n"
                + "second floor.";
        }
      return rep;  
    }
/*----------------------------------------------------------------------------*/
    @Override public String getDescription() {
        String rep = this.description;

        if (this.doesThisHaveIt("crystal orb") && this.level == 0) {
            rep = "The statue now stands holding the glinting crystal orb."; 
        }
        else if (this.doesThisHaveIt("crystal orb") && this.level == 1) {
            rep = "The statue stands holding the glowing orb. It hums softly."; 
        }
        else if (this.doesThisHaveIt("crystal orb") && this.level == 2) {
            rep = "The statue stands holding the glowing orb. It's humming quite\n"
                + "loudly now."; 
        }
        else if (this.doesThisHaveIt("crystal orb") && this.level == 3) {
            rep = "The statue has risen up to the next floor. Its tall base\n"
                + "is all that's left on this level."; 
        }        
        return rep;
    }
/*----------------------------------------------------------------------------*/
    @Override public String getSearchDialog() {
        String rep = this.searchDialog;
        
        if (this.searchable && this.doesThisHaveIt("crystal orb")) {
            rep = "The statue stands bearing the crystal orb.";
        }
        else if (! this.searchable) {
            rep = "The statue's palm is now out of reach.";
        }                
        return rep; 
    }
/*----------------------------------------------------------------------------*/
    @Override public String useEvent(Item item) {
        this.useDialog = "You set the orb into the statue's palm.";
        REF2.give(item, this.inv);
        
        return this.useDialog;
    }
/*----------------------------------------------------------------------------*/
}
