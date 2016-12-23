package Gallery;

import A_Super.Statue;
import A_Super.Room;

public class Gal_3E_Stat extends Statue {
    private int level;
    private final Room GAL5_REF;
    private final Room GAL7_REF;
    
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gal_3E_Stat(Room gal5, Room gal7) {
        super();
        this.GAL5_REF = gal5;
        this.GAL7_REF = gal7;
        this.level = 0;
        this.actDialog = "The statue is out of reach";
        this.description = "The statue now stands high in the central chamber\n"
                         + "at the thrid floor level. Its orb is cold yet again,\n"
                         + "but both of its eyes now glow brightly.";    
        this.searchDialog = "The statue's hand is out of reach";
    }
/*----------------------------------------------------------------------------*/
    public int getState() {
        return this.level;
    }
/*----------------------------------------------------------------------------*/
    public String activate(char color, Gal6_Cnn cnn) {
        String rep = "The beam of light shines into the central chamber.";
        
        if (GAL7_REF.hasFurniture("statue") && cnn.isOn() && this.level == 0) {
            
            if (color == 'D' && this.level == 0) {
                rep = this.raise(); 
            }              
            else if (this.level == 0) {
                rep = "The beam of light shines into the orb with no effect.";
            }
        }
        else if (GAL7_REF.hasFurniture("statue") && this.level == 1 && cnn.isOn())
            rep = "The beam of light shines at the orb, but the orb continues\n"
                + "to glow hellishly.";
        
        return rep;
    }     
/*----------------------------------------------------------------------------*/
    private String raise() {
        this.level++; 
        GAL5_REF.unlock();
     
        return "The crystal orb in the statue's palm glows with a dark\n"
            + "hellish glow. Cogwork can be heard behind the walls and\n"
            + "before long, you hear a clicking sound down below.";
    }
/*----------------------------------------------------------------------------*/
    @Override public String getDescription() {
        String rep = this.description;
        
        switch(this.level) {
            case 0:
                break;
            case 1:
                rep = "The statue stands in the central chamber holding the orb.\n"
                    + "Its eyes are brightly lit and the orb glows in a surreal\n"
                    + "dark light while humming loudly."; 
        }
        return rep;
    }
/*----------------------------------------------------------------------------*/
}


