package Foyer;

import Main.Player;
import Super.Staircase;
import Main.GUI;

public class Foy3_Strcs extends Staircase {
/* CONSTRUCTOR ---------------------------------------------------------------*/     
    public Foy3_Strcs(char direction, int height) {
        super(direction, height);
        this.description = "From the second floor switchback, the stairs lead\n"
                         + "to a top floor landing.";
        this.searchDialog = "In searching the stairs, you find it as clean and\n"
                          + "bare as the rest of this room.";  
    }
/*----------------------------------------------------------------------------*/
    @Override public String interact(String key) {     
        String ans;
        int[] c = Player.getOcc().getCoords(); // coordinates of player location.
        int Z = c[0]; int Y = c[1]; int X = c[2]; //Individual ZYX coordinates.
        
        GUI.menOut("There are two flights here.\nGo up or down?");
        
        do {
            ans = GUI.promptOut();
        } while (! ans.matches("up|down"));
        
        int m = ans.matches("up") ? -this.HT : this.HT; // Z coordinate modifier.
                
        Player.setOccupies(Z + m, Y, X); // moves the player's Z coordinate.
        playEffect();
        
        String rep = "You climb the stairs " + ans.toLowerCase() + ".";       

        GUI.roomOut(Player.getOcc().triggeredEvent());
        Player.describeRoom();
        
        return rep;
    }
/*----------------------------------------------------------------------------*/    
}