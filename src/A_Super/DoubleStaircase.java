package A_Super;

import A_Main.GUI;
import A_Main.Player;
/**
 * Some rooms have two sets of stairs.
 * Allow the player to interact with either one and avoid problems of ambiguity.
 * 
 * @author Kevin Rapa
 */
public class DoubleStaircase extends Staircase {
    // ========================================================================
    public DoubleStaircase () {
        super('b', 1); //'b' means both. DoubleStaircase does not use DIR.
    }
    // ========================================================================   
    @Override public String interact(String key) {     
        String ans;
        int[] c = Player.getOcc().getCoords(); // coordinates of player location.
        int Z = c[0]; int Y = c[1]; int X = c[2]; //Individual ZYX coordinates.
        
        GUI.menOut("There are two flights here.\n       <'u'> Go up\n       <'d'> Go down");
        
        do {
            ans = GUI.promptOut();
        } while (! ans.matches("[ud]|up|down"));
        
        int m = ans.matches("up|u") ? -this.HT : this.HT; // Z coordinate modifier.
                
        Player.setOccupies(Z + m, Y, X); // moves the player's Z coordinate.
        playEffect();
        
        String rep = "You climb the stairs " + (ans.matches("up|u") ? "up" : "down") + ".";       

        GUI.roomOut(Player.getOcc().triggeredEvent());
        Player.describeRoom();
        
        return rep;
    }
    // ========================================================================      
}


