package Foyer;

import Main.Player;
import Super.Staircase;
import Main.GUI;
import Super.Room;

public class Foy3_Strcs extends Staircase {
/* CONSTRUCTOR ---------------------------------------------------------------*/     
    public Foy3_Strcs(Player player, char direction, int height) {
        super(player, direction, height);
        this.description = "From the second floor switchback, the stairs lead\n"
                         + "to a top floor landing.";
        this.searchDialog = "In searching the stairs, you find it as clean and\n"
                          + "bare as the rest of this room.";  
    }
/*----------------------------------------------------------------------------*/
    @Override public String interact(Room[][][] map, String key) {     
        String ans;
        int[] c = REF.getOcc().getCoords(); // coordinates of player location.
        int Z = c[0]; int Y = c[1]; int X = c[2]; //Individual ZYX coordinates.
        
        GUI.menOut("There are two flights here.\nGo up or down?");
        
        do {
            ans = GUI.promptOut();
        } while (! ans.matches("[uU]p|[dD]own"));
        
        int m = ans.matches("[uU]p") ? -this.HT : this.HT; // Z coordinate modifier.
                
        this.REF.setOccupies(map[Z + m][Y][X]); // moves the player's Z coordinate.
        playEffect();
        
        String rep = "You climb the stairs " + ans.toLowerCase() + ".";       

        GUI.roomOut(REF.getOcc().triggeredEvent(map));
        REF.describeRoom();
        
        return rep;
    }
/*----------------------------------------------------------------------------*/    
}