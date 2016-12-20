package Gallery;

import Super.Furniture;
import Super.Room;

public class Gal_3E_Stat extends Furniture{
    private int level;
    private final Room REF;
    private final Room REF2;
    
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gal_3E_Stat(Room gal5, Room gal7) {
        super();
        this.searchable = false;
        this.REF = gal5;
        this.REF2 = gal7;
        this.level = 0;
        this.description = "The statue now stands high in the central chamber\n"
                         + "at the thrid floor level. Its orb is cold yet again,\n"
                         + "but both of its eyes now glow brightly.";    
        this.searchDialog = "The statue's hand is out of reach";
        this.addNameKeys("statue");
    }
/*----------------------------------------------------------------------------*/
    public int getState() {
        return this.level;
    }
/*----------------------------------------------------------------------------*/
    public String activate(char color, Gal6_Cnn cnn) {
        String rep = "The beam of light shines into the central chamber.";
        
        if (REF2.hasFurniture("statue") && cnn.isOn() && this.level == 0) {
            
            if (color == 'D' && this.level == 0) {
                rep = this.raise(); 
            }              
            else if (this.level == 0) {
                rep = "The beam of light shines into the orb with no effect.";
            }
        }
        else if (REF2.hasFurniture("statue") && this.level == 1 && cnn.isOn())
            rep = "The beam of light shines at the orb, but the orb continues\n"
                + "to glow hellishly.";
        
        return rep;
    }     
/*----------------------------------------------------------------------------*/
    private String raise() {
        this.level++; 
        REF.unlock();
     
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


