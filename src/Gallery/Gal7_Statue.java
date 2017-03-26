package Gallery;

import A_Main.AudioPlayer;
import A_Main.Id;
import A_Main.Player;
import A_Super.Furniture;

public class Gal7_Statue extends Furniture {
    private int level;
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gal7_Statue() {
        super();
        this.level = 0;
        this.actDialog = "The statue is out of reach";
        this.description = "The statue now stands high in the central chamber "
                         + "at the thrid floor level. Its orb is cold yet again, "
                         + "but both of its eyes now glow brightly.";    
        this.searchDialog = "The statue's hand is out of reach";
    }
/*----------------------------------------------------------------------------*/
    public int getLevel() {
        return this.level;
    }
/*----------------------------------------------------------------------------*/
    /**
     * Hits the orb in the statue's hand with light.
     * @param color the color of the beam.
     * @return returns a string of what happens.
     */
    public String activate(char color) {
        if (Player.getRoomObj(Id.GAL7).hasFurniture(this)) {
            if (level == 0) {
                if (color == 'D') {
                    return this.raise(); 
                }              
                else
                    return "The beam of light shines into the orb with no effect.";
            }
            else
                return "The beam of light shines at the orb, but the orb continues to glow hellishly.";
        }
        else
            return "The beam of light shines into the central chamber.";
    }     
/*----------------------------------------------------------------------------*/
    private String raise() {
        this.level++; 
        Player.getRoomObj(Id.GAL5).unlock();
        AudioPlayer.playEffect(38, 0.3);
        return "The crystal orb in the statue's palm glows with a dark "
             + "hellish glow. Cogwork can be heard behind the walls and "
             + "before long, you hear a clicking sound down below.";
    }
/*----------------------------------------------------------------------------*/
    @Override public String getDescription() {
        if (level == 1)
                return "The statue stands in the central chamber holding the orb. "
                     + "Its eyes are brightly lit and the orb glows in a surreal "
                     + "dark light while humming loudly."; 
        else 
            return this.description;
    }
/*----------------------------------------------------------------------------*/    
}


