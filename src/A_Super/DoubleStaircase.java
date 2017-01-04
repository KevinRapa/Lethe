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
        super(Direction.DOWN, 1); //Direction is UNUSED in Double stairs
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
        
        Direction dir = ans.matches("up|u") ? Direction.UP : Direction.DOWN; // Z coordinate modifier.
                
        Player.setOccupies(Z + dir.Z, Y, X); // moves the player's Z coordinate.
        playEffect();
        
        String rep = "You climb the stairs " + dir + ".";       

        GUI.roomOut(Player.getOcc().triggeredEvent());
        Player.describeRoom();
        
        return rep;
    }
    // ========================================================================      
}


