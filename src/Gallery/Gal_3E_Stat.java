package Gallery;

import A_Main.Player;
import A_Super.Statue;

public class Gal_3E_Stat extends Statue {
    private int level;
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gal_3E_Stat() {
        super();
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
    public String activate(char color, boolean isOn) {
        String rep = "The beam of light shines into the central chamber.";
        
        if (Player.getRoomRef("GAL7").hasFurniture("statue") && isOn && this.level == 0) {
            
            if (color == 'D' && this.level == 0) {
                rep = this.raise(); 
            }              
            else if (this.level == 0) {
                rep = "The beam of light shines into the orb with no effect.";
            }
        }
        else if (Player.getRoomRef("GAL7").hasFurniture("statue") && this.level == 1 && isOn)
            rep = "The beam of light shines at the orb, but the orb continues\n"
                + "to glow hellishly.";
        
        return rep;
    }     
/*----------------------------------------------------------------------------*/
    private String raise() {
        this.level++; 
        Player.getRoomRef("GAL5").unlock();
     
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


